package com.classcraft.demo.view;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ModuloRequest {
    private String titulo;

    @JsonCreator
    public ModuloRequest(@JsonProperty("titulo") String titulo){
        this.titulo=titulo;
    }
}
