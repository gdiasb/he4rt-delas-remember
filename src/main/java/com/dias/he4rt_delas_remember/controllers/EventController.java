package com.dias.he4rt_delas_remember.controllers;

import com.dias.he4rt_delas_remember.domain.DTO.EventRegisterDTO;
import com.dias.he4rt_delas_remember.domain.DTO.EventShowDTO;
import com.dias.he4rt_delas_remember.domain.DTO.EventUpdateDTO;
import com.dias.he4rt_delas_remember.services.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/v1")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping(path = "/events")
    public ResponseEntity<Page<EventShowDTO>> getEvents(@PageableDefault(size = 15) Pageable pageable) {
        return service.getAllEvents(pageable);
    }

    @GetMapping(path = "/events/{id}")
    public ResponseEntity<EventShowDTO> getEventById(@PathVariable Long id) {
        return service.getEventById(id);
    }


    @PostMapping("/events")
    public ResponseEntity<EventShowDTO> postEvent(@RequestBody EventRegisterDTO eventRegisterDTO,
                                                  UriComponentsBuilder uriComponentsBuilder) {
        return service.saveEvent(eventRegisterDTO, uriComponentsBuilder);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<EventShowDTO> updateById(@PathVariable Long id,
                                                   @RequestBody EventUpdateDTO eventUpdateDTO) {
        return service.updateEvent(id, eventUpdateDTO);
    }

    @DeleteMapping(path = "/events/{id}")
    public ResponseEntity<Void> inactiveById(@PathVariable Long id) {
        return service.inactiveEvent(id);
    }
}
