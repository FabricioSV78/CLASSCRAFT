package com.classcraft.demo.view;

import com.classcraft.demo.model.usuarios.Padre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroRequest {
    private String nombre;
    private String correo;
    private String contrasena;
    private long idPadre;
    private String tipo;

}
