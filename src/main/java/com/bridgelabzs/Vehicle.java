package com.bridgelabzs;

public class Vehicle {
    VehicleColour vehicleColour;
    VehicleSize vehicleSize;
    DriverType driverType;
    ParkingDateTime parkingDateTime;
    private String parkingDateAndTime;
    private String vehicleId;

    //CONSTRUCTOR
    public Vehicle(String vehicleId, DriverType driverType, VehicleSize vehicleSize, VehicleColour vehicleColour) {
        parkingDateTime = new ParkingDateTime();
        this.vehicleId = vehicleId;
        parkingDateAndTime = parkingDateTime.getDateTime();
        this.driverType = driverType;
        this.vehicleSize = vehicleSize;
        this.vehicleColour = vehicleColour;
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

    public enum VehicleColour {WHITE, BLUE}
}