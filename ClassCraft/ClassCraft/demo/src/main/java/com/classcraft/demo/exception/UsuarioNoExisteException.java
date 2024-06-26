package com.classcraft.demo.exception;

public class UsuarioNoExisteException extends RuntimeException{
    public UsuarioNoExisteException(String mensaje){
        super(mensaje);
    }
}
