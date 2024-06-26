package com.classcraft.demo.repository;

import com.classcraft.demo.model.ModuloCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloCursoRepository extends JpaRepository<ModuloCurso,Long> {
}
