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

    public Page<EventShowDTO> getEvents(Pageable pageable) {
        return repository.findAll(pageable).map(eventMapper::toEventShowDTO);
//        return repository.findAll(pageable).stream().map(eventMapper::toEventShowDTO).toList();
    }

    public ResponseEntity saveEvent(EventRegisterDTO eventRegisterDTO) {

        EventEntity eventEntity = eventMapper.toEventEntity(eventRegisterDTO);

        System.out.println(eventRegisterDTO);
        System.out.println(eventEntity);

        if (!eventRegisterDTO.deadline().isBefore(LocalDateTime.now())) {
            eventEntity.setStatus(true);
        } else {
            return ResponseEntity.badRequest().build();
        }
        repository.save(eventEntity);

        return ResponseEntity.ok().build();
    }


}
