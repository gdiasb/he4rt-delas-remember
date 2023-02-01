package com.dias.he4rt_delas_remember.services;

import com.dias.he4rt_delas_remember.domain.Entities.EventEntity;
import com.dias.he4rt_delas_remember.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<EventEntity> findAll() {
        return repository.findAll().stream().toList();
    }

    public String saveEvent(EventEntity eventEntity) {
        repository.save(eventEntity);
        return "Ok";
    }


}
