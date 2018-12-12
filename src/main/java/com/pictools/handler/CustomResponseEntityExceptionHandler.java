package com.pictools.handler;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.pictools.constraint.Constraints.all;
import static org.springframework.context.i18n.LocaleContextHolder.getLocale;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<?> handleDataIntegrityViolationException(Exception exception, WebRequest request) {
        if (exception.getCause() instanceof ConstraintViolationException) {
            if (exception.getCause().getCause() != null) {
                for (String constraint : all()) {
                    if (exception.getCause().getCause().getMessage().toUpperCase().contains(constraint.toUpperCase())) {
                        return new ResponseEntity<>(messageSource
                                .getMessage(constraint, new Object[]{}, getLocale()),
                                UNPROCESSABLE_ENTITY);
                    }
                }
            }
        }
        return new ResponseEntity<>(exception.getMessage(), UNPROCESSABLE_ENTITY);
    }

}
