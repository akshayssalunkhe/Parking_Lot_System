package com.bridgelabzs;

public class ParkingLotSystem {
    private Object vehicle;

    //METHOD TO PARK THE VEHICLE
    public boolean isPark(Object vehicle) {
        if (this.vehicle != null)
            return false;
        this.vehicle = vehicle;
        return true;
    }

    //METHOD TO UNPARK THE GIVEN VEHICLE
    public boolean unParkTheVehicle(Object vehicle) {
        this.vehicle = vehicle;
        if (this.vehicle.equals(vehicle)) {
            this.vehicle = null;
            return true;
        }
        return false;
    }
}