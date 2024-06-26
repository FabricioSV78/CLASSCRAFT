package com.classcraft.demo.model.usuarios;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Padre extends Usuario{

    @Column(nullable = false)  
    @OneToMany(mappedBy = "padre")
    private List<Estudiante> estudiantes =new ArrayList<>();

    public Padre(String nombreU, String correoElectronico, String contrasena) {
        super(correoElectronico, nombreU, contrasena);
    }
}
