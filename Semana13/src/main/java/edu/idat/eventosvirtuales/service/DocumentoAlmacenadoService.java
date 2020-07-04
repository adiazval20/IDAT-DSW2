package edu.idat.eventosvirtuales.service;

import edu.idat.eventosvirtuales.entity.DocumentoAlmacenado;
import edu.idat.eventosvirtuales.repository.DocumentoAlmacenadoRepository;
import edu.idat.eventosvirtuales.utils.GenericResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

import static edu.idat.eventosvirtuales.utils.Global.*;

@Service
@Transactional
public class DocumentoAlmacenadoService implements BaseService<DocumentoAlmacenado, Long> {
    private DocumentoAlmacenadoRepository repo;
    private FileStorageService storageService;

    public DocumentoAlmacenadoService(DocumentoAlmacenadoRepository repo, FileStorageService storageService) {
        this.repo = repo;
        this.storageService = storageService;
    }

    @Override
    public GenericResponse list() {
        return new GenericResponse(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA, repo.list());
    }

    @Override
    public GenericResponse find(Long aLong) {
        return null;
    }

    @Override
    public GenericResponse save(DocumentoAlmacenado obj) {
        return null;
    }

    @Override
    public GenericResponse delete(Long aLong) {
        return null;
    }

    @Override
    public HashMap<String, Object> validate(DocumentoAlmacenado obj) {
        return null;
    }
}
