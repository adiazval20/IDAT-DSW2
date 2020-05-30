package edu.idat.controller;

import edu.idat.entity.Cliente;
import edu.idat.exception.CustomException;
import edu.idat.service.ClienteService;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
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
    public Iterable<Cliente> list() {
        return service.list();
    }

    @PostMapping
    public Cliente create(@Valid @RequestBody Cliente cliente, Errors errors) {
        if (errors.hasErrors()) {
            throwError(errors);
        }
        return service.save(cliente);
    }

    private void throwError(Errors errors) {
        String message = "";
        int index = 0;
        for (ObjectError r : errors.getAllErrors()) {
            if (index > 0) {
                message += " | ";
            }
            message += String.format("Parameter: %s - Message: %s", r.getObjectName(), r.getDefaultMessage());
            index++;
        }

        throw new CustomException(message);
    }
}
