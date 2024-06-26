package com.classcraft.demo.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContenidoDTO {
    private String titulo;
    private String tipo; // "archivo" o "url"
    @JsonIgnore
    private MultipartFile archivo; // Usado solo si tipo es "archivo"
    //private String url; // Usado solo si tipo es "url"


}
