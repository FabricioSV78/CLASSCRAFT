package com.classcraft.demo.exception;

public class ModuloNoExisteException extends RuntimeException{
    public ModuloNoExisteException(String mensaje){
        super(mensaje);
    }
}
