package com.classcraft.demo.repository;

import com.classcraft.demo.model.usuarios.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaestroRepository extends JpaRepository<Maestro,Long> {
}
