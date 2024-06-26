package com.classcraft.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ContenidoSem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long idContenido;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

}



