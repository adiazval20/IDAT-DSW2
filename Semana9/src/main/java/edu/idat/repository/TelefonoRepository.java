package edu.idat.repository;

import edu.idat.entity.Telefono;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TelefonoRepository extends CrudRepository<Telefono, Integer> {
    @Query("SELECT t FROM Telefono t WHERE t.cliente.id = :clienteId AND t.eliminado = false")
    List<Telefono> listarPorClienteId(int clienteId);

    @Query("SELECT t FROM Telefono t WHERE t.cliente.id = :clienteId AND t.principal = true AND t.eliminado = false")
    Optional<Telefono> listarPrincipalPorCliente(int clienteId);
}
