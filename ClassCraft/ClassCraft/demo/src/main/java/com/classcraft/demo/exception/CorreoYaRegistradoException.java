package com.classcraft.demo.exception;

public class CorreoYaRegistradoException extends RuntimeException{
    public CorreoYaRegistradoException (String mensaje){
        super(mensaje);
    }
}
