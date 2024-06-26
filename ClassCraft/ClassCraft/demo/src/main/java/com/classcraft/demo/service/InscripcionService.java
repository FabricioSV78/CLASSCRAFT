package com.classcraft.demo.service;

import com.classcraft.demo.model.Curso;
import com.classcraft.demo.model.Inscripcion;
import com.classcraft.demo.model.usuarios.Estudiante;
import com.classcraft.demo.repository.CursoRepository;
import com.classcraft.demo.repository.EstudianteRepository;
import com.classcraft.demo.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Inscripcion registrarEstudianteEnCurso(Long estudianteId, Long cursoId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudiante(estudiante);
        inscripcion.setCurso(curso);
        inscripcion.setEstado("INSCRITO");

        return inscripcionRepository.save(inscripcion);
    }
}
