package com.classcraft.demo.controller;

import com.classcraft.demo.service.ModuloCursoService;
import com.classcraft.demo.view.ModuloCursoResponse;
import com.classcraft.demo.view.ModuloRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ModuloCursoController {

    @Autowired
    private ModuloCursoService moduloCursoService;

    @PostMapping("/modulo/crear/{id}")
    public ModuloCursoResponse crearModulo(@PathVariable Long id, @RequestBody ModuloRequest moduloRequest){
        return new ModuloCursoResponse(moduloCursoService.crearModulo(id,moduloRequest.getTitulo()).getTitulo());
    }

    @PutMapping("/modulo/editar/{id}")
    public ModuloCursoResponse editarModulo(@PathVariable Long id, @RequestBody ModuloRequest moduloRequest){
        return new ModuloCursoResponse(moduloCursoService.editarModulo(id,moduloRequest.getTitulo()).getTitulo());
    }

    @DeleteMapping("/modulo/eliminar/{id}")
    public ResponseEntity<String> eliminarModulo(@PathVariable Long id){
        moduloCursoService.eliminarModulo(id);
        return new ResponseEntity<>("Modulo eliminado con exito", HttpStatus.OK);
    }
}
