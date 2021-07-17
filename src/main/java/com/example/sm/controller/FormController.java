package com.example.sm.controller;

import com.example.sm.controller.request.FormCreateRequest;
import com.example.sm.controller.response.EventResponse;
import com.example.sm.model.Form;
import com.example.sm.service.FormService;
import com.example.sm.state_machine.FormEvents;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/forms")
public class FormController {

    @Autowired
    private FormService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Form createProduct(@RequestBody FormCreateRequest request) {
        return service.createForm(request);
    }

    @GetMapping
    public List<Form> getEntities() {
        return service.getAllForms();
    }

    @GetMapping("/{id}")
    public Form getEntity(@PathVariable("id") Long id) {
        return service.getForm(id);
    }

    @PostMapping("/{id}/send/{event}")
    public EventResponse sendEvent(@PathVariable("id") Long id, @PathVariable("event") FormEvents event) {
        return service.updateState(id, event);
    }
}
