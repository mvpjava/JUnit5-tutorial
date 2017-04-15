package com.mvpjava.electricity;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class MixedJunitVersions {

    @org.junit.Test
    public void Junit4Test() {
        org.junit.Assert.assertFalse("Should not be empty", 
                "Junit 4 Tests can also be run".isEmpty());
    }

    @org.junit.jupiter.api.Test
    void Junit5Test() {
        org.junit.jupiter.api.Assertions.assertFalse("Junit 5 Tests from here on in".isEmpty(), 
                "Should not be empty");
    }
}
