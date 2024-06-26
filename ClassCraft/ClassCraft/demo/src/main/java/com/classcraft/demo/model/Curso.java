package com.classcraft.demo.model;


import java.util.ArrayList;
import java.util.List;

import com.classcraft.demo.model.usuarios.Maestro;
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


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long idCurso;

    @Column(nullable = false)
    private String nombreC;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany
    private List<ContenidoSem> contenidos = new ArrayList<>();

    @OneToMany(mappedBy = "curso")
    private List<Inscripcion> inscripciones = new ArrayList<>();

    @OneToMany(mappedBy = "curso")
    private List<Actividad> actividades = new ArrayList<>();

    @ManyToOne
    private Maestro maestro;




}
