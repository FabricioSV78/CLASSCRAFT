package com.classcraft.demo.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MensajeRequest {
    String asunto;
    String contenido;
    Long remitenteId;
    Long destinatarioId;

}
