package com.bridgelabzs;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotSystemTest {
    ParkingLotSystem parkingLotSystem = new ParkingLotSystem();

    @Test
    public void givenAVehicleToPark_WhenParkedInParkingLot_ShouldReturnTrue() {
        Object vehicle = new Object();
        boolean park = false;
        try {
            park = parkingLotSystem.isPark(vehicle);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(park);
    }

    @Test
    public void givenAVehicleToPark_WhenThereAreOtherVehicles_ShouldReturnTrue() {
        Object vehicleOne = new Object();
        Object vehicleTwo = new Object();
        try {
            parkingLotSystem.isPark(vehicleOne);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
        boolean park = false;
        try {
            park = parkingLotSystem.isPark(vehicleTwo);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(park);
    }

    @Test
    public void givenAVehicle_WhenUnParkedFromParkingLot_ShouldReturnTrue() {
        Object vehicle = new Object();
        try {
            parkingLotSystem.isPark(vehicle);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
        boolean unPark = false;
        try {
            unPark = parkingLotSystem.unParkTheVehicle(vehicle);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(unPark);
    }

    @Test
    public void givenAVehicle_WhenNotPresentInParkingLot_ShouldReturnException() {
        Object vehicleOne = new Object();
        Object vehicle = new Object();
        try {
            parkingLotSystem.isPark(vehicleOne);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
        boolean unPark;
        try {
            unPark = parkingLotSystem.unParkTheVehicle(vehicle);
            Assert.assertFalse(unPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicleToPark_WhenParkingLotIsFull_ShouldInformAuthorities() {
        boolean park = false;
        try {
            int index;
            for (index = 1; index <= 6; index++) {
                Object vehicleIndex = new Object();
                park = parkingLotSystem.isPark(vehicleIndex);
            }
            Assert.assertTrue(park);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }
}