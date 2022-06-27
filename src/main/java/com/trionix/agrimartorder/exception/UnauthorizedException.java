package com.trionix.agrimartorder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;


public class UnauthorizedException extends HttpStatusCodeException {
    //check the Unauthorization
    public UnauthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
