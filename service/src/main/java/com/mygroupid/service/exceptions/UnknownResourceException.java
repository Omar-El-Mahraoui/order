package com.mygroupid.service.exceptions;
// copied and adapted code from funiversity example switchfully

public class UnknownResourceException extends OrderException {
    public UnknownResourceException(String field, String resource) {
        super(String.format("We could not find a %s for the provided %s", resource, field));
    }
}
