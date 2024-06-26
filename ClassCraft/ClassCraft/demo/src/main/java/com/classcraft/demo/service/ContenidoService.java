package com.classcraft.demo.service;




import com.classcraft.demo.model.ArchivoCS;
import com.classcraft.demo.model.Curso;



import com.classcraft.demo.repository.ArchivoCSRepository;
import com.classcraft.demo.repository.CursoRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ContenidoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ArchivoCSRepository archivoCSRepository;
    //@Autowired
    //private UrlRepository urlRepository;

    @Transactional
    public ArchivoCS guardarArchivo(Long cursoId, String titulo, MultipartFile archivo) throws IOException {
        if (archivo == null || archivo.isEmpty()) {
            throw new IllegalArgumentException("El archivo no puede ser nulo o vacío.");
        }

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        ArchivoCS nuevoArchivo = new ArchivoCS();
        nuevoArchivo.setTitulo(titulo);
        nuevoArchivo.setContenido(archivo.getBytes());
        nuevoArchivo.setCurso(curso);

        return archivoCSRepository.save(nuevoArchivo);
    }



    /*@Transactional
    public Url guardarUrl(Long cursoId, String titulo, String url) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Url nuevaUrl = new Url();
        nuevaUrl.setTitulo(titulo);
        nuevaUrl.setContenido(url);
        nuevaUrl.setCurso(curso);
        return urlRepository.save(nuevaUrl);
    }*/

    // Método para obtener un archivo por su ID
    public ArchivoCS obtenerArchivo(Long contenidoId) throws RuntimeException {
        Optional<ArchivoCS> resultado = archivoCSRepository.findById(contenidoId);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            throw new RuntimeException("Archivo no encontrado con ID: " + contenidoId);
        }
    }


    /*public Url obtenerUrl(Long contenidoId) throws RuntimeException {
        Optional<Url> resultado = urlRepository.findById(contenidoId);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            throw new RuntimeException("URL no encontrado con ID: " + contenidoId);
        }
    }*/
}
