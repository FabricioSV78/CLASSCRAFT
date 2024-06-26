package com.classcraft.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.classcraft.demo.model.Mensaje;


@Repository
public interface MensajeRepository extends JpaRepository<Mensaje,Long> {

}