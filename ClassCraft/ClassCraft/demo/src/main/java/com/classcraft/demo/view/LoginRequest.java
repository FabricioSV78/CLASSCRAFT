package com.classcraft.demo.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
    String correo;
    String contrasena;
}
