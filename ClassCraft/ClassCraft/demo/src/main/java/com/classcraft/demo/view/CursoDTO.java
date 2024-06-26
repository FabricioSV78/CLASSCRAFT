package com.classcraft.demo.view;

import com.classcraft.demo.model.Actividad;
import com.classcraft.demo.model.ContenidoSem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    String nombre;
    String descripcion;
    Long maestroId;


    public CursoDTO(String nombreC) {
    }
}
