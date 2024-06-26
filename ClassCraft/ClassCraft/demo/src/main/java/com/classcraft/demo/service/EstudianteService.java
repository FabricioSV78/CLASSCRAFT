package com.classcraft.demo.service;

import com.classcraft.demo.model.Curso;
import com.classcraft.demo.model.Inscripcion;
import com.classcraft.demo.model.usuarios.Estudiante;
import com.classcraft.demo.model.usuarios.Maestro;
import com.classcraft.demo.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<String> obtenerNombresCursosPorEstudianteId(Long estudianteId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return estudiante.getInscripciones().stream()
                .map(inscripcion -> inscripcion.getCurso().getNombreC())
                .collect(Collectors.toList());
    }
}
