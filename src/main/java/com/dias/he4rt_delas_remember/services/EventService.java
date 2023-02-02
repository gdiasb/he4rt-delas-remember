package com.dias.he4rt_delas_remember.services;

import com.dias.he4rt_delas_remember.domain.DTO.EventShowDTO;
import com.dias.he4rt_delas_remember.domain.Entities.EventEntity;
import com.dias.he4rt_delas_remember.domain.Mappers.EventShowMapper;
import com.dias.he4rt_delas_remember.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    private EventShowMapper eventShowMapper;

    public EventService(EventRepository repository, EventShowMapper eventShowMapper) {
        this.eventShowMapper = eventShowMapper;
        this.repository = repository;
    }

    public List<EventShowDTO> findAll() {

//        EventShowDTO eventDTO = EventShowMapper.INSTANCE.toEventShowDTO();
        return repository.findAll().stream().map(eventShowMapper::toEventShowDTO).toList();
    }

    public String saveEvent(EventEntity eventEntity) {
        repository.save(eventEntity);
        return "Ok";
    }


}
