/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvpjava.electricity;

import com.mvpjava.junit5.extensions.MockitoExtension;
import com.mvpjava.junit5.extensions.TimingExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
@ExtendWith({MockitoExtension.class, TimingExtension.class})
class StereoTest {

    Stereo stereo;

    @BeforeEach
    void setUp() {
        stereo = new Stereo();
    }

    @DisplayName("Confirm correct state after instantiation")
    @Test
    public void newStereoShouldReportExpectedDefaultValues() {
        assertFalse(stereo.isPlugged(), "Should not be plugged in");
        assertFalse(stereo.isPowered(), "Should not be powered on");
    }

    @DisplayName("[When Plugged into Electrical Outlet]")
    @Nested
    class PluggedIntoElectricalOutlet {

        @Mock
        ElectricalOutlet electricalOutlet;

        @BeforeEach
        void init() {
            stereo.plugin(electricalOutlet);
        }

        @Test
        @DisplayName("Should indicate plugged in")
        public void confirmPluggedIn() {
            assertTrue(stereo.isPlugged(), "Should have reported plugged in");
        }

        @Nested
        @DisplayName("[When Stereo is Powered ON]")
        class StereoPoweredON {

            @BeforeEach
            void init() {
                when(electricalOutlet.getElectricity()).thenReturn(new Electricity());
                stereo.powerOn();
            }

            @Test
            @Tag("Performance")
            @DisplayName("Should indicate powered ON when electricity is being provided")
            public void powerOn() throws InterruptedException {
                assertTrue(stereo.isPowered(), "Should be powered on");
                Thread.sleep(1100);
            }

            @Test
            @DisplayName("Play music")
            public void shouldPlayMusicWhenPlayRequested(@Mock PlayList playList, TestInfo testInfo, TestReporter testReporter) {
                String expectedSong = "ThunderStruck";
                when(playList.getFirstTrackFromAlbum("Blow up your Stereo")).thenReturn(expectedSong);
                assertEquals(expectedSong, stereo.playMusic(), () -> "Suppose to be playing song; " + expectedSong);
            }

        }

    }
}
