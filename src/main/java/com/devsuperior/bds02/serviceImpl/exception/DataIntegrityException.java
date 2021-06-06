package com.devsuperior.bds02.serviceImpl.exception;

public class DataIntegrityException extends RuntimeException {

    public DataIntegrityException(String msg){
        super(msg);
    }
}
