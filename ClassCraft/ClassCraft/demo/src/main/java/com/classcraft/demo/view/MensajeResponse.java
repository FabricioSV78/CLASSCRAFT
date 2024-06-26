package com.classcraft.demo.view;

import com.classcraft.demo.model.Mensaje;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeResponse {
    private String asunto;
    private String contenido;
    private LocalDateTime fechaEnvio;
    private String remitente;

    public MensajeResponse(Mensaje mensaje) {
        this.asunto = mensaje.getAsunto();
        this.contenido = mensaje.getContenidoM();
        this.fechaEnvio = mensaje.getFechaEnvio();
        this.remitente = mensaje.getRemitente().getNombreU();
    }


}
