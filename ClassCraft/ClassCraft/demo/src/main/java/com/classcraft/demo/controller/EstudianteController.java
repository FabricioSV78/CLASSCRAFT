package com.classcraft.demo.controller;

import com.classcraft.demo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/cursos/nombre/{estudianteId}")
    public ResponseEntity<List<String>> listarNombresCursos(@PathVariable Long estudianteId) {
        try {
            List<String> nombresCursos = estudianteService.obtenerNombresCursosPorEstudianteId(estudianteId);
            return ResponseEntity.ok(nombresCursos);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
