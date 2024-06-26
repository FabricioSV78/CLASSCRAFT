package com.classcraft.demo.controller;

import com.classcraft.demo.service.MensajeriaService;
import com.classcraft.demo.view.MensajeRequest;
import com.classcraft.demo.view.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensajeria")
public class MensajeriaController {
    @Autowired
    private MensajeriaService mensajeriaService;

    @PostMapping("/enviar")
    public ResponseEntity<MensajeResponse> enviarMensaje(@RequestBody MensajeRequest mensajeRequest) {
        return mensajeriaService.enviarMensaje(mensajeRequest.getAsunto(),mensajeRequest.getContenido(),mensajeRequest.getRemitenteId(),mensajeRequest.getDestinatarioId());
    }

    @GetMapping("/ver/recibidos/{id}")
    public ResponseEntity<List<MensajeResponse>> verMensajesRecibidos(@PathVariable Long id) {
        return mensajeriaService.verMensajesRecibidos(id);
    }

    @GetMapping("/ver/enviados/{id}")
    public ResponseEntity<List<MensajeResponse>> verMensajesEnviados(@PathVariable Long id) {
        return mensajeriaService.verMensajesEnviados(id);
    }
}
