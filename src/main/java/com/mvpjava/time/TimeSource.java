/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvpjava.time;

import java.time.LocalTime;

/**
 *
 * @author aluis
 */
public interface TimeSource {
    
    public LocalTime getCurrentTime();
    
}
