package com.classcraft.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.classcraft.demo.model.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad,Long> {
    
}
