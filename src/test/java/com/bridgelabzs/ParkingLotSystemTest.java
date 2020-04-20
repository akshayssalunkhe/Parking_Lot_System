package com.bridgelabzs;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

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

    @Test
    public void givenAVehicleToPark_WhenThereIsVacantSpaceInParkingLot_ShouldInformAuthorities() {
        boolean park = false;
        boolean unpark = false;
        Object vehicleIndex = new Object();
        Object[] vehicleIndexNo = new Object[20];
        try {
            int index;
            for (index = 1; index <= 6; index++) {
                vehicleIndex = new Object();
                vehicleIndexNo[index] = vehicleIndex;
                park = parkingLotSystem.isPark(vehicleIndex);
            }
            unpark = parkingLotSystem.unParkTheVehicle(vehicleIndexNo[2]);
            unpark = parkingLotSystem.unParkTheVehicle(vehicleIndexNo[4]);
            park = parkingLotSystem.isPark(vehicleIndex);

            Assert.assertTrue(park);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicleToPark_WhenParkingLotOwnerGenerateNumber_AttendantShouldParkTheCar() {
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        HashMap parkingLotMap = null;
        Integer key = parkingLotOwner.generateParkingSlotNumber();
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        Object vehicle = new Object();
        boolean park;
        try {
            park = parkingLotAttendant.isPark(key, vehicle);
            Assert.assertTrue(park);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }
}