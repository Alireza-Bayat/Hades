package com.hades.exceptions;

/**
 * <p> in cases that utilizing specific annotation is required but annotation is not present
 *
 * @author alireza_bayat
 * created on 10/12/21
 */
public class AnnotationNotPresentException extends RuntimeException {

    public AnnotationNotPresentException(String message) {
        super(message);
    }
}
