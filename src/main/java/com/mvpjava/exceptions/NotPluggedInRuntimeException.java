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
public class NotPluggedInRuntimeException extends RuntimeException {

    /**
     * Creates a new instance of <code>NotPluggedInRuntimeException</code>
     * without detail message.
     */
    public NotPluggedInRuntimeException() {
    }

    /**
     * Constructs an instance of <code>NotPluggedInRuntimeException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NotPluggedInRuntimeException(String msg) {
        super(msg);
    }
}
