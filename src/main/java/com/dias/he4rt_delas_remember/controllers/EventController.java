package com.dias.he4rt_delas_remember.controllers;

import com.dias.he4rt_delas_remember.domain.Entities.EventEntity;
import com.dias.he4rt_delas_remember.services.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public List<EventEntity> getEvents() {
        return service.findAll();
    }
}
