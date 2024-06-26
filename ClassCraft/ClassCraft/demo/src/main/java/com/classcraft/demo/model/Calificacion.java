package com.classcraft.demo.model;

import com.classcraft.demo.model.usuarios.Estudiante;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long idCalificacion;

    @Column(nullable = false)
    private float nota;


    @ManyToOne
    private Estudiante estudiante;

    @ManyToOne
    private Actividad actividad;
    
}
