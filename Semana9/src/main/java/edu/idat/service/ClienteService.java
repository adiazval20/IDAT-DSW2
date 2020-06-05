package edu.idat.service;

import edu.idat.entity.Cliente;
import edu.idat.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Iterable<Cliente> list() {
        return repository.listar();
    }

    public Cliente find(int id) {
        return repository.findById(id).orElse(new Cliente());
    }

    public Cliente save(Cliente c) {
        return repository.save(c);
    }

    public void delete(int id) {
        Cliente cliente = repository.findById(id).orElse(new Cliente());
        if (cliente.getId() != 0) {
            cliente.setEliminado(true);
            repository.save(cliente);
        }
    }
}
