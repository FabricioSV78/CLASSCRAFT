package com.classcraft.demo.exception;

public class PadreNoExisteException extends RuntimeException{
    public PadreNoExisteException(String mensaje){
        super(mensaje);
    }
}
