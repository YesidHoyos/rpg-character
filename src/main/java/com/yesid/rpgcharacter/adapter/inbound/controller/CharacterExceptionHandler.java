package com.yesid.rpgcharacter.adapter.inbound.controller;

import com.yesid.rpgcharacter.aop.exception.SessionExpiredException;
import com.yesid.rpgcharacter.domain.exception.CharacterNotFoundException;
import com.yesid.rpgcharacter.domain.exception.InvalidCharacterException;
import com.yesid.rpgcharacter.domain.exception.InvalidUpgradeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CharacterExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvalidCharacterException.class, InvalidUpgradeException.class})
    protected ResponseEntity<Object> handleInvalidRequest(RuntimeException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getMessage(), HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST,
                request);
    }

    @ExceptionHandler(value = CharacterNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(RuntimeException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getMessage(), HttpHeaders.EMPTY, HttpStatus.NOT_FOUND,
                request);
    }

    @ExceptionHandler(value = SessionExpiredException.class)
    protected ResponseEntity<Object> handleSessionExpired(RuntimeException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getMessage(), HttpHeaders.EMPTY, HttpStatus.UNAUTHORIZED,
                request);
    }
}