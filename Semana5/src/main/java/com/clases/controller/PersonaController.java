package com.clases.controller;

import com.clases.entity.Persona;
import com.clases.entity.PersonaDireccion;
import com.clases.service.PersonaService;
import com.sun.corba.se.impl.orb.PropertyOnlyDataCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    private final PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Persona> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Persona find(@PathVariable int id) {
        return service.find(id);
    }

    @GetMapping("/dto/{id}")
    public PersonaDireccion findAll(@PathVariable int id) {
        return service.findAll(id);
    }
}
