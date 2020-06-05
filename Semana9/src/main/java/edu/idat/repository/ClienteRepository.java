package edu.idat.repository;

import edu.idat.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    @Query("SELECT c FROM Cliente c WHERE c.eliminado IS false")
    Iterable<Cliente> listar();
}
