package edu.idat.service;

import edu.idat.entity.Cliente;
import edu.idat.entity.ClienteTelefonoDTO;
import edu.idat.entity.Telefono;
import edu.idat.repository.ClienteRepository;
import edu.idat.repository.TelefonoRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private ClienteRepository repository;
    private TelefonoRepository telefonoRepository;

    public ClienteService(ClienteRepository repository, TelefonoRepository telefonoRepository) {
        this.repository = repository;
        this.telefonoRepository = telefonoRepository;
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

    public ClienteTelefonoDTO listClienteTelefonoDTO(int id) {
        Cliente cliente = repository.findById(id).orElse(new Cliente());
        Telefono telefonoPrincipal = telefonoRepository.listarPrincipalPorCliente(id).orElse(new Telefono());

        ClienteTelefonoDTO dto = new ClienteTelefonoDTO();
        dto.setClienteId(cliente.getId());
        dto.setApellidoPaterno(cliente.getApellidoPaterno());
        dto.setApellidoMaterno(cliente.getApellidoMaterno());
        dto.setNombres(cliente.getNombres());
        dto.setAnioNacimiento(cliente.getAnioNacimiento());
        dto.setTelefonoId(telefonoPrincipal.getId());
        dto.setNumero(telefonoPrincipal.getNumero());
        dto.setOperador(telefonoPrincipal.getOperador());

        return dto;
    }
}
