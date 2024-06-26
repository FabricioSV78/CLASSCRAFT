package com.classcraft.demo.model;


import com.classcraft.demo.model.usuarios.Usuario;
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

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long idMensaje;

    @Column(nullable = false)
    private String contenidoM;

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false)
    private LocalDateTime fechaEnvio;

    @ManyToOne
    private Usuario remitente;

    @ManyToOne
    private Usuario destinatario;

    public Mensaje(String asunto,String contenidoM, Usuario remitente, Usuario destinatario) {
        this.asunto=asunto;
        this.contenidoM = contenidoM;
        this.fechaEnvio=LocalDateTime.now();
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    
}
