package com.hades.exceptions;

/**
 * <p> will be thrown in cases that query string got syntax errors
 *
 * @author alireza_bayat
 * created on 10/27/21
 */
public class QueryGeneratorException extends RuntimeException {

    public QueryGeneratorException(String message) {
        super(message);
    }
}
