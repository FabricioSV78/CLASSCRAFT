package com.classcraft.demo.repository;

import com.classcraft.demo.model.Curso;
import com.classcraft.demo.view.VerUsuariosResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.classcraft.demo.model.Inscripcion;

import java.util.List;


@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion,Long> {
    @Query("select NEW com.classcraft.demo.view.VerUsuariosResponse (i.estudiante.nombreU) from Inscripcion i WHERE i.curso=:curso")
    List<VerUsuariosResponse> findAllByCurso(Curso curso);
}