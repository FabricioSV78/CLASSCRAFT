package com.classcraft.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuloCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long idCurso;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Curso curso;

    @Column(nullable = false)
    private String titulo;

    public ModuloCurso(Curso curso, String titulo){
        this.curso=curso;
        this.titulo=titulo;
    }
}
