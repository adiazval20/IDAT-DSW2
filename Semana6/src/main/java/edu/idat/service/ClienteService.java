package edu.idat.service;

import edu.idat.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private List<Cliente> clientes;

    public ClienteService() {
        clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Carvajal", "Suarez", "Gabriel", 2000));
        clientes.add(new Cliente(2, "Díaz", "Perez", "Jimena", 1995));
        clientes.add(new Cliente(3, "Barboza", "Alvitez", "Fernando", 2001));
    }

    public List<Cliente> list() {
        return clientes;
    }

    public Cliente find(int id) {
        Cliente cliente = new Cliente();
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                cliente = c;
                break;
            }
        }
        return cliente;
    }

    public Cliente save(Cliente c) {
        if (c.getId() == 0) {
            c.setId(getNextId());
            clientes.add(c);
        } else {
            int index = clientes.indexOf(find(c.getId()));
            clientes.set(index, c);
        }
        return c;
    }

    private int getNextId() {
        int nextId = 0;
        for (Cliente c : clientes) {
            if (c.getId() > nextId) {
                nextId = c.getId();
            }
        }
        return nextId + 1;
    }
}
