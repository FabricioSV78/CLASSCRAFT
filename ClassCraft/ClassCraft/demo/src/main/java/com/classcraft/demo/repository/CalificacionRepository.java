package com.classcraft.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.classcraft.demo.model.Calificacion;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion,Long> {
    
}
