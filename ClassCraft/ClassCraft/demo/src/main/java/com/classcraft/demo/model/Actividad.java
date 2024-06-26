package com.classcraft.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore

    private Long idActividad;

    @Column(nullable = false)
    private String nombreA;

    @Column(nullable = false)
    private boolean estadoA;

    @Column(nullable = false)
    private String descripcionA;

    @Column(nullable = false)
    private LocalDateTime fechaEntrega;


    @OneToMany(mappedBy = "actividad")
    private List<Calificacion> calificaciones = new ArrayList<>();


    @ManyToOne
    private Curso curso;


    
}
