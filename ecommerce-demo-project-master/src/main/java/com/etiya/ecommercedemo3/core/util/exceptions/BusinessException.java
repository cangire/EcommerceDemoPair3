package com.etiya.ecommercedemo3.core.util.exceptions;

public class BusinessException extends RuntimeException{
      //business exception sınıfı yaratıldı
    public BusinessException(String message){
        super(message);
    }
}
