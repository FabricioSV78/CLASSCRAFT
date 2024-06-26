package com.classcraft.demo.model.usuarios;

import java.util.ArrayList;
import java.util.List;

import com.classcraft.demo.model.Curso;

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
public class Maestro extends Usuario{


    @OneToMany(mappedBy = "maestro")
    private List<Curso> cursos = new ArrayList<>();

    public Maestro(String correoElectronico, String nombreU, String contrasena) {
        super(correoElectronico, nombreU, contrasena);
    }
}
