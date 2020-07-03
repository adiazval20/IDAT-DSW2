package edu.idat.eventosvirtuales.service;

import edu.idat.eventosvirtuales.config.FileStorageProperties;
import edu.idat.eventosvirtuales.exception.FileStorageException;
import edu.idat.eventosvirtuales.exception.MyFileNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {
    private Path fileStorageLocation;

    public FileStorageService(FileStorageProperties fileStorageProperties) {
        fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(fileStorageLocation);
        } catch (IOException e) {
            throw new FileStorageException("No se pudo crear el directorio", e);
        }
    }

    public String storeFile(MultipartFile file, String fileName) {
        String originalName = StringUtils.cleanPath(file.getOriginalFilename());
        String extension = originalName.substring(originalName.lastIndexOf("."));

        if (fileName.equals("")) {
            fileName = UUID.randomUUID().toString();
        }

        Path targetLocation = fileStorageLocation.resolve(fileName + extension);
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;

        } catch (IOException e) {
            throw new FileStorageException("No se pudo almacenar el archivo", e);
        }
    }

    public Resource loadResource(String fileName) {
        Path path = this.fileStorageLocation.resolve(fileName).normalize();
        try {
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("Archivo no encontrado: " + fileName);
            }

        } catch (MalformedURLException e) {
            throw new MyFileNotFoundException("Ha ocurrido un error al intentar acceder al archivo: " + fileName, e);
        }
    }
}
















