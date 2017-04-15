/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvpjava.electricity;

import com.mvpjava.exceptions.NoElectricityRuntimeException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.expectThrows;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
//@SelectPackages("com.mvpjava.electricity")
class ElectricalOutletTest {

    ElectricalOutlet electricalOutlet;
    ElectricityProvider electricityProvider;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Aquiring resources ... ");
    }

    @BeforeEach
    void beforeEachTest() {
        electricityProvider = mock(ElectricityProvider.class);
        electricalOutlet = new ElectricalOutlet(electricityProvider);
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("Resetting Resources ... ");
        electricityProvider = null;
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("Releasing resources ... ");
    }

    @Test
    @DisplayName("Electrical Outlet will be able to supply Electricity when requested")
    void shouldGenerateElectricityWhenImplProvided() {
        when(electricalOutlet.getElectricity()).thenReturn(new Electricity());

        assertTrue(electricalOutlet.getElectricity() != null, () -> "Electricity " + "should have" + " been returned");
        assertFalse(electricalOutlet.getElectricity() == null, "Electricity should have been returned");
        assertNotNull(electricalOutlet.getElectricity(), () -> "Electricity should have been returned");
    }

    @Test
    @DisplayName("Simulating a power outage: a No Electricity Exception gets thrown")
    void shouldThrowExceptionWhenNoElectricityIsAvailable() {
        when(electricityProvider.provideElectricity()).thenThrow(new NoElectricityRuntimeException());

        assertThrows(NoElectricityRuntimeException.class, () -> electricalOutlet.getElectricity());
    }

    @Test
    @DisplayName("Passing null ElectricityProvider will not generate Electricity: exception thrown when requesting Electricity")
    void shouldThrowExceptionWhenNoImplProvided() {
        ElectricalOutlet outletWithoutElectricityProvider = new ElectricalOutlet(null);

        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> outletWithoutElectricityProvider.getElectricity());
        assertAll(
                "Analyzing Exception properties",
                () -> assertEquals(IllegalStateException.class, exception.getClass()),
                () -> assertEquals("No ElectricityProvider impl. provided!", exception.getMessage())
        );
    }

    @Disabled("Need more information on requirement X to complete. Awaiting feedback from client")
    @Test
    @DisplayName("Apply new Requirement to Electrical Outlet")
    void testNewRequirementX() {
        String country = System.getProperty("user.country");
        assumingThat(country.equals("CA"), () -> System.exit(1));

        // rest ...
    }
}
