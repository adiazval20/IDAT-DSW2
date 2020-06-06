package edu.idat.service;

import edu.idat.entity.Telefono;
import edu.idat.repository.TelefonoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefonoService {
    private TelefonoRepository repository;

    public TelefonoService(TelefonoRepository repository) {
        this.repository = repository;
    }

    public List<Telefono> listByClienteId(int clienteId) {
        return repository.listarPorClienteId(clienteId);
    }
}
