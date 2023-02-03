package com.dias.he4rt_delas_remember.controllers;

import com.dias.he4rt_delas_remember.domain.DTO.EventRegisterDTO;
import com.dias.he4rt_delas_remember.domain.DTO.EventShowDTO;
import com.dias.he4rt_delas_remember.services.EventService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping(path = "/events")
    public List<EventShowDTO> getEvents(@PageableDefault(size = 15) Pageable pageable) {
        return service.getEvents(pageable);
    }


    @PostMapping("/event")
    public ResponseEntity postEvent(@RequestBody EventRegisterDTO eventRegisterDTO) {
        return service.saveEvent(eventRegisterDTO);
    }
}
