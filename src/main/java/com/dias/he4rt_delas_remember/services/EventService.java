package com.dias.he4rt_delas_remember.services;

import com.dias.he4rt_delas_remember.domain.DTO.EventRegisterDTO;
import com.dias.he4rt_delas_remember.domain.DTO.EventShowDTO;
import com.dias.he4rt_delas_remember.domain.Entities.EventEntity;
import com.dias.he4rt_delas_remember.domain.Mappers.EventMapper;
import com.dias.he4rt_delas_remember.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@Service
public class EventService {

    private final EventRepository repository;

    private final EventMapper eventMapper;

    @Autowired
    public EventService(EventRepository repository, EventMapper eventMapper) {
        this.eventMapper = eventMapper;
        this.repository = repository;
    }

    public ResponseEntity<Page<EventShowDTO>> getAllEvents(Pageable pageable) {
        Page<EventShowDTO> page = repository.findAll(pageable).map(eventMapper::toEventShowDTO);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity<EventShowDTO> getEventById(Long id) {
        EventEntity eventEntity = repository.getReferenceById(id);
        EventShowDTO eventShowDTO = eventMapper.toEventShowDTO(eventEntity);
        return ResponseEntity.ok(eventShowDTO);
    }

    @Transactional
    public ResponseEntity saveEvent(EventRegisterDTO eventRegisterDTO, UriComponentsBuilder uriComponentsBuilder) {

        EventEntity eventEntity = eventMapper.toEventEntity(eventRegisterDTO);

        System.out.println(eventRegisterDTO);
        System.out.println(eventEntity);

        if (!eventRegisterDTO.deadline().isBefore(LocalDateTime.now())) {
            eventEntity.setStatus(true);
        } else {
            return ResponseEntity.badRequest().build();
        }

        repository.save(eventEntity);
        URI entityURI =
                uriComponentsBuilder.path("/events/{id}").buildAndExpand(eventEntity.getId()).toUri();

        EventShowDTO eventShowDTO = eventMapper.toEventShowDTO(eventEntity);

        return ResponseEntity.created(entityURI).body(eventShowDTO);
    }


}
