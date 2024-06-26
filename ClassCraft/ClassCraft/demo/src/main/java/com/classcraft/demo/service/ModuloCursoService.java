package com.classcraft.demo.service;

import com.classcraft.demo.exception.CursoNoExisteException;
import com.classcraft.demo.exception.ModuloNoExisteException;
import com.classcraft.demo.model.Curso;
import com.classcraft.demo.model.ModuloCurso;
import com.classcraft.demo.repository.CursoRepository;
import com.classcraft.demo.repository.ModuloCursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModuloCursoService {
    @Autowired
    private ModuloCursoRepository moduloCursoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public ModuloCurso crearModulo(Long id, String nombre){
        Optional<Curso> cursoOptional=cursoRepository.findById(id);
        if (cursoOptional.isEmpty()){
            throw new CursoNoExisteException("El curso no existe");
        }
        Curso curso=cursoOptional.get();
        ModuloCurso moduloCurso = new ModuloCurso(curso, nombre);
        //
        return moduloCursoRepository.save(moduloCurso);
    }

    @Transactional
    public ModuloCurso editarModulo(Long id, String titulo){
        Optional<ModuloCurso> moduloCursoOptional = moduloCursoRepository.findById(id);
        if (moduloCursoOptional.isEmpty()){
            throw new ModuloNoExisteException("El modulo no existe");
        }
        ModuloCurso moduloCurso = moduloCursoOptional.get();
        moduloCurso.setTitulo(titulo);
        return moduloCursoRepository.save(moduloCurso);
    }

    public void eliminarModulo(Long id){
        Optional<ModuloCurso> moduloCursoOptional = moduloCursoRepository.findById(id);
        if (moduloCursoOptional.isEmpty()){
            throw new ModuloNoExisteException("El Modulo no existe");
        }
        moduloCursoRepository.deleteById(id);
    }

}
