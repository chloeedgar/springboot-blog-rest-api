package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException {
// we throw this exception whenever we write some business logic
    // or validate request parameters

    private HttpStatus httpStatus;
    private String message;

    public BlogAPIException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public BlogAPIException(String message, HttpStatus httpStatus, String message1) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;
    }





}
