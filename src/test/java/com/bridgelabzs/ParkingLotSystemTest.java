package com.bridgelabzs;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotSystemTest {
    ParkingLotSystem parkingLotSystem = new ParkingLotSystem();

    @Test
    public void givenAVehicleToPArk_WhenParkedInParkingLot_ShouldReturnTrue() {
        Object vehicle = new Object();
        boolean park = parkingLotSystem.isPark(vehicle);
        Assert.assertTrue(park);
    }
}
