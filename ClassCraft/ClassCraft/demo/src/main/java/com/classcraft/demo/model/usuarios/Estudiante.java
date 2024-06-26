package com.classcraft.demo.model.usuarios;

import java.util.ArrayList;
import java.util.List;

import com.classcraft.demo.model.Calificacion;
import com.classcraft.demo.model.Inscripcion;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Estudiante extends Usuario{


    @OneToMany(mappedBy = "estudiante")
    private List<Calificacion> calificaciones = new ArrayList<>();

    @OneToMany(mappedBy = "estudiante")
    private List<Inscripcion> inscripciones = new ArrayList<>();

    @ManyToOne
    private Padre padre;

    public Estudiante(String correoElectronico, String nombreU, String contrasena,Padre padre){
        super(correoElectronico,nombreU,contrasena);
        this.padre=padre;
    }
   

}
