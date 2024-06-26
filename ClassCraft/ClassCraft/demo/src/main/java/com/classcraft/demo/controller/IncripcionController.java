package com.classcraft.demo.controller;

import com.classcraft.demo.model.Curso;
import com.classcraft.demo.model.Inscripcion;
import com.classcraft.demo.service.EstudianteService;
import com.classcraft.demo.service.InscripcionService;
import com.classcraft.demo.view.InscripcionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IncripcionController {

    @Autowired
    private InscripcionService inscripcionService;



    @PostMapping("/Inscripcion")
    public ResponseEntity<String> registrarEstudiante(@RequestBody InscripcionDTO inscripcionDTO) {
        Inscripcion inscripcion = inscripcionService.registrarEstudianteEnCurso(
                inscripcionDTO.getEstudianteId(),
                inscripcionDTO.getCursoId()
        );
        return new ResponseEntity<>("Estudiante inscrito con éxito en el curso.", HttpStatus.CREATED);
    }


}
