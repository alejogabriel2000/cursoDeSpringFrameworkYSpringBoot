package com.stereo.peliculas.servicios;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ArchivoService implements IArchivoService {
    @Override
    public void guardar(String archivo, InputStream bytes) {

        try {
            eliminar(archivo);
            Files.copy(bytes, resolverPath(archivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String archivo) {
        try {
            Files.deleteIfExists(resolverPath(archivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResponseEntity<Resource> get(String archivo) {

        Resource resource = null;
        try {
            resource = new UrlResource(resolverPath(archivo).toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    private Path resolverPath(String archivo) {
        return Paths.get("archivos").resolve(archivo).toAbsolutePath();
    }
}
