package com.example.deliverybackend.interfaces;

import com.example.deliverybackend.globals.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
public abstract class BaseController {
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleException(BaseException e) {
        log.error("error message : "+e.getErrorMsg());
        return Response.fail(e.getErrorMsg());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Response handleException(Exception e) {
        log.error("error message : "+e.getMessage());
        return Response.fail(e.getMessage());
    }
}
