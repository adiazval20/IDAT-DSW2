package edu.idat.eventosvirtuales.controller;

import edu.idat.eventosvirtuales.entity.DocumentoAlmacenado;
import edu.idat.eventosvirtuales.service.DocumentoAlmacenadoService;
import edu.idat.eventosvirtuales.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/documento-almacenado")
public class DocumentoAlmacenadoController implements BaseController<DocumentoAlmacenado, Long> {
    private DocumentoAlmacenadoService service;

    public DocumentoAlmacenadoController(DocumentoAlmacenadoService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public GenericResponse list() {
        return service.list();
    }

    @Override
    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable Long id) {
        return null;
    }

    @Override
    public GenericResponse save(DocumentoAlmacenado obj) {
        return null;
    }

    @Override
    public GenericResponse update(Long aLong, DocumentoAlmacenado obj) {
        return null;
    }

    @Override
    public GenericResponse delete(Long aLong) {
        return null;
    }
}
