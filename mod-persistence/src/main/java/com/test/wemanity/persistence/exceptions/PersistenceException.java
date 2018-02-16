package com.test.wemanity.persistence.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by JeanDodo on 15/02/2018.
 */
@Getter
@Setter
public class PersistenceException extends Exception {

    private String message;

    public PersistenceException(String message) {
        super(message);
    }
}