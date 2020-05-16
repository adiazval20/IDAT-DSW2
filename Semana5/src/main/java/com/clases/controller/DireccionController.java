package com.clases.controller;

import com.clases.entity.Direccion;
import com.clases.service.DireccionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direccion")
public class DireccionController {
    public final DireccionService service;

    public DireccionController(DireccionService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Direccion> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Direccion find(@PathVariable int id) {
        return service.find(id);
    }
}
