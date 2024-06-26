package com.classcraft.demo.model.usuarios;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long idUsuario;

    @Column(nullable = false)
    private String nombreU;

    @Column(nullable = false, unique = true)
    private String correoElectronico;

    @Column(nullable = false)
    @JsonIgnore
    private String contrasena;


    public Usuario(String correoElectronico, String nombreU, String contrasena) {
        this.correoElectronico = correoElectronico;
        this.nombreU = nombreU;
        this.contrasena = contrasena;
    }

}
