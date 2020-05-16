package com.clases.service;

import com.clases.entity.Direccion;
import com.clases.entity.Persona;
import com.clases.entity.PersonaDireccion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    private final DireccionService direccionService;
    private List<Persona> personas;

    public PersonaService(DireccionService direccionService) {
        this.direccionService = direccionService;

        personas = new ArrayList<>();

        Persona maria = new Persona(1, "Díaz", "Sandoval", "María");
        maria.setDireccionId(1);

        personas.add(maria);
        personas.add(new Persona(2, "Perez", "Jimenez", "José"));
        personas.add(new Persona(3, "Suarez", "Peralez", "Gabriel"));
    }

    public Iterable<Persona> list() {
        return personas;
    }

    public Persona find(int id) {
        Persona persona = new Persona();
        for (Persona p : personas) {
            if (p.getId() == id) {
                persona = p;
                break;
            }
        }
        return persona;
    }

    public PersonaDireccion findAll(int id) {
        Persona persona = find(id);
        Direccion direccion = direccionService.find(persona.getDireccionId());

        PersonaDireccion personaDireccion = new PersonaDireccion();
        personaDireccion.setId(persona.getId());
        personaDireccion.setNombreCompleto(String.format("%s %s %s", persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getNombres()));
        personaDireccion.setDireccion(String.format("%s-%s-%s", direccion.getUrbanizacion(), direccion.getCalle(), direccion.getNumero()));

        return personaDireccion;
    }
}
