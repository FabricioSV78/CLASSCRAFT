package com.classcraft.demo.controller;

import com.classcraft.demo.model.ArchivoCS;

import com.classcraft.demo.service.ContenidoService;
import com.classcraft.demo.view.ContenidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
class ContenidoController {
    @Autowired
    private ContenidoService contenidoService;

    /*@PostMapping("/{cursoId}/url")
    public ResponseEntity<?> subirURL(@PathVariable Long cursoId, @RequestBody ContenidoDTO contenidoDTO) {
        try {
            if ("url".equals(contenidoDTO.getTipo())) {
                Url url = contenidoService.guardarUrl(cursoId, contenidoDTO.getTitulo(), contenidoDTO.getUrl());
                contenidoDTO.setUrl(url.getContenido());  // Actualiza el DTO con la URL guardada
            }
            return ResponseEntity.ok(contenidoDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en la solicitud: " + e.getMessage());
        }
    }*/

    @PostMapping("/{cursoId}/contenido")
    public ResponseEntity<?> subirArchivo(@PathVariable Long cursoId, @ModelAttribute ContenidoDTO contenidoDTO) {
        try {
            if ("archivo".equals(contenidoDTO.getTipo()) && contenidoDTO.getArchivo() != null) {
                contenidoService.guardarArchivo(cursoId, contenidoDTO.getTitulo(), contenidoDTO.getArchivo());
                contenidoDTO.setTipo("archivo");
                contenidoDTO.setArchivo(null); // Asegúrate de remover el archivo del DTO
            }
            // Crea una copia del DTO sin el archivo para la respuesta
            ContenidoDTO respuestaDTO = new ContenidoDTO(contenidoDTO.getTitulo(), contenidoDTO.getTipo(), null);
            return ResponseEntity.ok(respuestaDTO);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error al procesar el archivo: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en la solicitud: " + e.getMessage());
        }
    }

    @GetMapping("/archivo/{contenidoId}/obtener")
    public ResponseEntity<ByteArrayResource> descargarArchivo(@PathVariable Long contenidoId) {
        try {
            ArchivoCS archivo = contenidoService.obtenerArchivo(contenidoId);
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("application/pdf"))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo.getTitulo() + "\"")
                    .body(new ByteArrayResource(archivo.getContenido()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /*@GetMapping("/url/{contenidoId}/obtener")
    public ResponseEntity<?> obtenerUrlPorId(@PathVariable Long contenidoId) {
        try {
            Url url = contenidoService.obtenerUrl(contenidoId);
            return ResponseEntity.ok(url); // Devuelve la URL encontrada
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build(); // Devuelve una respuesta de no encontrado si no existe la URL
        }
    }*/


}
