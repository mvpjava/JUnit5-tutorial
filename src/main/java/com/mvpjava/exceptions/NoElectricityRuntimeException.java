/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvpjava.exceptions;

/**
 *
 * @author aluis
 */
public class NoElectricityRuntimeException extends RuntimeException {

    /**
     * Creates a new instance of <code>NoElectricityRuntimeException</code>
     * without detail message.
     */
    public NoElectricityRuntimeException() {
    }

    /**
     * Constructs an instance of <code>NoElectricityRuntimeException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NoElectricityRuntimeException(String msg) {
        super(msg);
    }
}
