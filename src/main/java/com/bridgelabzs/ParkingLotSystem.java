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
}
