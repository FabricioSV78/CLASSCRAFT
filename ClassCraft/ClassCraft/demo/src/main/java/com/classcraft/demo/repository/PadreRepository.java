package com.classcraft.demo.repository;

import com.classcraft.demo.model.usuarios.Padre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PadreRepository extends JpaRepository<Padre,Long> {
    public Optional<Padre> findByIdUsuario(Long id);
}
