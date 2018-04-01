package com.mygroupid.service.exceptions;
// copied code from funiversity example switchfully

public abstract class OrderException extends RuntimeException{

    public OrderException(String message) {
        super(message);
    }

}
