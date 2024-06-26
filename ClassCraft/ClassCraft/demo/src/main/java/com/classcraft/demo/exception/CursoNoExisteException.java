package com.classcraft.demo.exception;

public class CursoNoExisteException extends RuntimeException{
    public CursoNoExisteException(String mensaje){
        super(mensaje);
    }
}
