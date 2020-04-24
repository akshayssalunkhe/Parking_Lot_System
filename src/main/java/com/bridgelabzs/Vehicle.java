package com.bridgelabzs;

import java.time.LocalDateTime;

public class Vehicle {
    String attendantName;
    VehicleColour vehicleColour;
    VehicleSize vehicleSize;
    DriverType driverType;
    ParkingDateTime parkingDateTime;
    public String vehicleId;
    VehicleModel vehicleModel;
    public LocalDateTime parkingDateAndTime;

    //CONSTRUCTOR
    public Vehicle(String vehicleId, DriverType driverType, VehicleSize vehicleSize,
                   VehicleColour vehicleColour, VehicleModel vehicleModel, String attendantName) {
        parkingDateTime = new ParkingDateTime();
        this.vehicleId = vehicleId;
        parkingDateAndTime = parkingDateTime.getDateTime();
        this.driverType = driverType;
        this.vehicleSize = vehicleSize;
        this.vehicleColour = vehicleColour;
        this.vehicleModel = vehicleModel;
        this.attendantName = attendantName;
    }

    //METHOD TO GET VEHICLE ID
    public String getVehicleId() {
        return vehicleId;
    }

    //ENUM
    public enum DriverType {HANDICAP, NORMAL}

    public enum VehicleSize {LARGE, SMALL}

    public enum VehicleColour {WHITE, BLUE}

    public enum VehicleModel {BMW, TOYOTA}
}