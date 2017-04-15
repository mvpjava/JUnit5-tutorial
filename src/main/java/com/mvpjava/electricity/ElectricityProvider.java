package com.mvpjava.electricity;

import com.mvpjava.exceptions.NoElectricityRuntimeException;

public interface ElectricityProvider {

    public Electricity provideElectricity() throws NoElectricityRuntimeException;
    public default  String getPowerSourceDetails(){
        return "";
    };
    
}
