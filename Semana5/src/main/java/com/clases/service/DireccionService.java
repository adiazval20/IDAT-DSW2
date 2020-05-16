package com.clases.service;

import com.clases.entity.Direccion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DireccionService {
    private List<Direccion> direccions;

    public DireccionService() {
        direccions = new ArrayList<>();
        direccions.add(new Direccion(1, "Santa Victoria", "Calle", 150));
        direccions.add(new Direccion(2, "Los Parques", "Otra calle", 250));
    }

    public Iterable<Direccion> list() {
        return direccions;
    }

    public Direccion find(int id) {
        Direccion direccion = new Direccion();
        for (Direccion d : direccions) {
            if (d.getId() == id) {
                direccion = d;
                break;
            }
        }
        return direccion;
    }
}
