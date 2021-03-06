package org.yosa.stapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yosa.stapi.exceptions.BadRequestException;
import org.yosa.stapi.exceptions.ForbiddenException;
import org.yosa.stapi.exceptions.NotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> notFoundHandler(NotFoundException exception){
        return new HashMap<String, Object>()
                {{ put("message", exception.getMessage()); put("status", 404); }};
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> badRequestException(BadRequestException exception){
        return new HashMap<String, Object>()
                {{ put("message", exception.getMessage()); put("status", 400); }};
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Map<String, Object> forbiddenException(){
        return new HashMap<String, Object>()
                {{ put("message", "Forbidden"); put("status", 403); }};
    }
}
