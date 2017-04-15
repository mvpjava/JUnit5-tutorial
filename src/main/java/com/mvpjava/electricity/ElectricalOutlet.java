package com.mvpjava.electricity;

import com.mvpjava.exceptions.NoElectricityRuntimeException;
import java.util.Objects;

public class ElectricalOutlet {

    private final ElectricityProvider electricityProvider;

    public ElectricalOutlet(ElectricityProvider electricityProvider) {
        this.electricityProvider = electricityProvider;
    }

    public Electricity getElectricity() throws NoElectricityRuntimeException {
        if (Objects.isNull(getElectricityProvider())) {
            throw new IllegalStateException("No ElectricityProvider impl. provided!");
        }
        
        /*may throw NoElectricityRuntimeException if ever there is no elecricity
        * available, it will depend on quality of implementation 
        */
        return getElectricityProvider().provideElectricity();
    }

    private ElectricityProvider getElectricityProvider() {
        return this.electricityProvider;
    }

}
