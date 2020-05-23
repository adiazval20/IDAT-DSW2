package edu.idat.controller;

import edu.idat.entity.Cliente;
import edu.idat.exception.CustomException;
import edu.idat.service.ClienteService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    private ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> list() {
        return service.list();
    }

    @PostMapping
    public Cliente create(@Valid @RequestBody Cliente cliente, Errors errors) {
        if (errors.hasErrors()) {
            throw new CustomException("ENCONTRÉ UN ERROR!");
        }
        return service.save(cliente);
    }
}
