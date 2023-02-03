package com.dias.he4rt_delas_remember.services;

import com.dias.he4rt_delas_remember.domain.DTO.EventRegisterDTO;
import com.dias.he4rt_delas_remember.domain.DTO.EventShowDTO;
import com.dias.he4rt_delas_remember.domain.Entities.EventEntity;
import com.dias.he4rt_delas_remember.domain.Mappers.EventMapper;
import com.dias.he4rt_delas_remember.repositories.EventRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    private final EventMapper eventMapper;

    public EventService(EventRepository repository, EventMapper eventMapper) {
        this.eventMapper = eventMapper;
        this.repository = repository;
    }

    public List<EventShowDTO> getEvents(Pageable pageable) {
        return repository.findAll().stream().map(eventMapper::toEventShowDTO).toList();
    }

    public ResponseEntity saveEvent(EventRegisterDTO eventRegisterDTO) {

        EventEntity eventEntity = eventMapper.toEventEntity(eventRegisterDTO);

        if (!eventRegisterDTO.deadline().isBefore(LocalDate.now())) {
            eventEntity.setStatus(true);
        } else {
            return ResponseEntity.badRequest().build();
        }
        repository.save(eventEntity);

        return ResponseEntity.ok().build();
    }


}
