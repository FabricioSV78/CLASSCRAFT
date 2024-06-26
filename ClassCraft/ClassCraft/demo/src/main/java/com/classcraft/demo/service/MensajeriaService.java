package com.classcraft.demo.service;

import com.classcraft.demo.view.MensajeRequest;
import com.classcraft.demo.view.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class MensajeriaService {
    @Autowired
    private RestTemplate restTemplate;

    //private static final String ENVIAR_MENSAJE_URL = "http://localhost:8081/mensaje/enviar";// Cambia la URL según sea necesario

    public ResponseEntity<MensajeResponse> enviarMensaje(String asunto, String contenido, Long remitenteId, Long destinatarioId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        MensajeRequest mensajeRequest = new MensajeRequest(asunto, contenido, remitenteId, destinatarioId);

        HttpEntity<MensajeRequest> entity = new HttpEntity<>(mensajeRequest, headers);

        return restTemplate.exchange(
                "http://localhost:8081/mensaje/enviar",
                HttpMethod.POST,
                entity,
                MensajeResponse.class);
    }

    public ResponseEntity<List<MensajeResponse>> verMensajesRecibidos(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<MensajeRequest> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "http://localhost:8081/mensaje/ver/recibidos/"+id,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference <List<MensajeResponse>>() {});
    }

    public ResponseEntity<List<MensajeResponse>> verMensajesEnviados(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<MensajeRequest> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "http://localhost:8081/mensaje/ver/enviados/"+id,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference <List<MensajeResponse>>() {});
    }
}
