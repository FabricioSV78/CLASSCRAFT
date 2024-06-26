package com.classcraft.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data   
@EqualsAndHashCode(callSuper=false)
public class ArchivoCS extends ContenidoSem{

    @Lob
    @Column(nullable = false)
    private byte[] contenido;
    
}
