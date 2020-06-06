package edu.idat.controller;

import edu.idat.entity.Telefono;
import edu.idat.service.TelefonoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/telefono")
public class TelefonoController {
    private TelefonoService service;

    public TelefonoController(TelefonoService service) {
        this.service = service;
    }

    @GetMapping("/porCliente/{clienteId}")
    public List<Telefono> listByClienteId(@PathVariable int clienteId) {
        return service.listByClienteId(clienteId);
    }
}
