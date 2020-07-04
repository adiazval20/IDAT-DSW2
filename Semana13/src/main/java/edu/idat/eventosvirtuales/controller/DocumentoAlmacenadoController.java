package edu.idat.eventosvirtuales.controller;

import edu.idat.eventosvirtuales.entity.DocumentoAlmacenado;
import edu.idat.eventosvirtuales.service.DocumentoAlmacenadoService;
import edu.idat.eventosvirtuales.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public GenericResponse save(@ModelAttribute DocumentoAlmacenado obj) {
        return service.save(obj);
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
