package com.bridgelabzs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkingLotSystemTest {
    ParkingLotSystem parkingLotSystem = null;
    Vehicle vehicle = null;
    ParkingLotOwner parkingLotOwner = null;
    AirportSecurity airportSecurity = null;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Date date = new Date();

    @Before
    public void setUp() throws Exception {
        parkingLotSystem = new ParkingLotSystem(3);
        parkingLotOwner = new ParkingLotOwner();
        airportSecurity = new AirportSecurity();
    }

    @Test
    public void givenAVehicleToPark_WhenParkedInParkingLot_ShouldReturnTrue() {
        try {
            vehicle = new Vehicle("1");
            parkingLotSystem.park(vehicle);
            boolean isPark = parkingLotSystem.isVehicleParked(vehicle);
            Assert.assertTrue(isPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenAlreadyParkedInParkingLot_ShouldThrowException() {
        parkingLotSystem = new ParkingLotSystem(2);
        try {
            parkingLotSystem.park(new Vehicle("1"));
            parkingLotSystem.park(new Vehicle("1"));
            parkingLotSystem.park(new Vehicle("3"));
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.PARKING_LOT_IS_FULL, e.type);
        }
    }

    @Test
    public void givenAVehicle_WhenNotParkedInParkingLot_ShouldReturnFalse() {
        vehicle = new Vehicle("1");
        boolean isPark = parkingLotSystem.isVehicleParked(vehicle);
        Assert.assertFalse(isPark);
    }

    @Test
    public void givenAVehicle_WhenUnParkedFromParkingLot_ShouldReturnTrue() {
        try {
            Vehicle vehicle1 = new Vehicle("1");
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.unPark(vehicle1);
            boolean isUnPark = parkingLotSystem.isVehicleUnPark(vehicle1);
            Assert.assertTrue(isUnPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenNoVehicleUnParked_ShouldThrowException() {
        try {
            Vehicle vehicle1 = new Vehicle("2");
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.isVehicleUnPark(vehicle1);
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.NOT_PARKED_HERE, e.type);
        }
    }

    @Test
    public void givenAVehicle_WhenNotUnParked_ShouldReturnFalse() {
        Vehicle vehicle1 = new Vehicle("1");
        try {
            parkingLotSystem.park(vehicle1);
            boolean isUnPark = parkingLotSystem.isVehicleUnPark(vehicle1);
            Assert.assertFalse(isUnPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenThereIsSpace1inParkingLot_ShouldAllowToPark() {
        Vehicle vehicle1 = new Vehicle("1");
        Vehicle vehicle2 = new Vehicle("2");
        Vehicle vehicle3 = new Vehicle("3");
        try {
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.park(vehicle2);
            parkingLotSystem.unPark(vehicle1);
            parkingLotSystem.park(vehicle3);
            boolean isPark = parkingLotSystem.isVehicleParked(vehicle3);
            Assert.assertTrue(isPark);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenAlreadyParked_ShouldThrowException() {
        Vehicle vehicle1 = new Vehicle("1");
        try {
            parkingLotSystem.park(vehicle1);
            parkingLotSystem.park(vehicle1);
        } catch (ParkingLotSystemException e) {
            Assert.assertEquals(ParkingLotSystemException.ExceptionType.VEHICLE_ALREADY_PARKED, e.type);
        }
    }

    @Test
    public void givenAVehicle_WhenAskForPosition_ShouldReturnPosition() {
        Vehicle vehicle1 = new Vehicle("1");
        try {
            parkingLotSystem.park(vehicle1);
            String vehiclePosition = parkingLotSystem.getVehiclePosition(vehicle1);
            Assert.assertEquals("VH 01", vehiclePosition);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_WhenToPark_ShouldReturnParkingDateTime() {
        vehicle = new Vehicle("1");
        try {
            parkingLotSystem.park(vehicle);
            String dateTime = formatter.format(date);
            String parkingDateAndTime = vehicle.getParkingDateAndTime();
            Assert.assertEquals(dateTime, parkingDateAndTime);
        } catch (ParkingLotSystemException e) {
            e.printStackTrace();
        }
    }
}