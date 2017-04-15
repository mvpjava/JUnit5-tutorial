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
public class NotPoweredOnRuntimeException extends RuntimeException {

    /**
     * Creates a new instance of <code>NotPoweredOnRuntimeException</code>
     * without detail message.
     */
    public NotPoweredOnRuntimeException() {
    }

    /**
     * Constructs an instance of <code>NotPoweredOnRuntimeException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NotPoweredOnRuntimeException(String msg) {
        super(msg);
    }
}
