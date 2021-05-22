package com.b2c.productcatalogue.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductCatalogueException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String message;
    private String errorCode;


}
