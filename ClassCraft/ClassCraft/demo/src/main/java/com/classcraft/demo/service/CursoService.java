package com.classcraft.demo.service;

import com.classcraft.demo.exception.CursoNoExisteException;
import com.classcraft.demo.model.Curso;
import com.classcraft.demo.model.usuarios.Maestro;
import com.classcraft.demo.repository.CursoRepository;
import com.classcraft.demo.repository.InscripcionRepository;
import com.classcraft.demo.repository.MaestroRepository;
import com.classcraft.demo.view.VerUsuariosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private MaestroRepository maestroRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public Curso crearCurso(Curso curso, Long maestroId) {
        Maestro maestro = maestroRepository.findById(maestroId)
                .orElseThrow(() -> new RuntimeException("Maestro no encontrado"));
        curso.setMaestro(maestro);  // Asignamos el maestro al curso
        return cursoRepository.save(curso);
    }

    public List<Curso> obtenerCursosPorMaestroId(Long maestroId) {
        Maestro maestro = maestroRepository.findById(maestroId).orElseThrow(() -> new RuntimeException("Maestro no encontrado"));
        return new ArrayList<>(maestro.getCursos());
    }

    public List<VerUsuariosResponse> verUsuarios(Long id) {
        List<VerUsuariosResponse> usuarios=new ArrayList<>();
        Curso curso=cursoRepository.findById(id).orElseThrow(()->new CursoNoExisteException("Curso no encontrado"));
        usuarios=inscripcionRepository.findAllByCurso(curso);
        usuarios.add(new VerUsuariosResponse(curso.getMaestro().getNombreU()));
        return usuarios;
    }

}