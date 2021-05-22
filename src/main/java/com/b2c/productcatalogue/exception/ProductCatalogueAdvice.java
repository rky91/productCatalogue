package com.b2c.productcatalogue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ProductCatalogueAdvice {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleAllException(Exception e) {
        return error(INTERNAL_SERVER_ERROR, e);
    }

    @ExceptionHandler({ProductCatalogueException.class})
    public ResponseEntity<String> handleInternalException(ProductCatalogueException e) {
        return error(INTERNAL_SERVER_ERROR, e);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
