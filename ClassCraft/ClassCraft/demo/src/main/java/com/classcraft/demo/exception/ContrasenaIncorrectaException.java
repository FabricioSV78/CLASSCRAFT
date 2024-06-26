package com.classcraft.demo.exception;

public class ContrasenaIncorrectaException extends RuntimeException{
    public ContrasenaIncorrectaException(String mensaje){
        super(mensaje);
    }
}
