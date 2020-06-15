package ru.education.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseEntity {

    private String message;
    private String error;
    private Integer status;

    public ErrorResponseEntity(String message, String error, Integer status) {
        this.message = message;
        this.error = error;
        this.status = status;
    }
}
