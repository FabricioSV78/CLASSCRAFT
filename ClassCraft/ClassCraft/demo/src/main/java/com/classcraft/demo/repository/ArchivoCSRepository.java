package com.classcraft.demo.repository;

import com.classcraft.demo.model.Actividad;
import com.classcraft.demo.model.ArchivoCS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivoCSRepository extends JpaRepository<ArchivoCS,Long> {
}
