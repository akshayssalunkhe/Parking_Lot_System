package com.bridgelabzs;

public class Vehicle {
    VehicleSize vehicleSize;
    DriverType driverType;
    ParkingDateTime parkingDateTime;
    private String parkingDateAndTime;
    private String vehicleId;

    //CONSTRUCTOR
    public Vehicle(String vehicleId, DriverType driverType, VehicleSize vehicleSize) {
        parkingDateTime = new ParkingDateTime();
        this.vehicleId = vehicleId;
        parkingDateAndTime = parkingDateTime.getDateTime();
        this.driverType = driverType;
        this.vehicleSize = vehicleSize;
    }

    //METHOD TO RETURN PARKING TIME
    public String getParkingDateAndTime() {
        return parkingDateAndTime;
    }

    //METHOD TO GET VEHICLE ID
    public String getVehicleId() {
        return vehicleId;
    }

    //ENUM
    public enum DriverType {HANDICAP, NORMAL}

    public enum VehicleSize {LARGE, SMALL}
}