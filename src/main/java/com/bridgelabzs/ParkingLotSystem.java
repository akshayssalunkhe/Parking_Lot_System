package com.bridgelabzs;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {
    List<Object> vehicle = new ArrayList<Object>();

    //METHOD TO PARK THE VEHICLE
    public boolean isPark(Object vehicleToPark) throws ParkingLotSystemException {
        if (this.vehicle.isEmpty()) {
            vehicle.add(vehicleToPark);
            return true;
        } else if (!this.vehicle.isEmpty() && (!this.vehicle.contains(vehicleToPark)) && (this.vehicle.size() < 5)) {
            vehicle.add(vehicleToPark);
            return true;
        } else
            throw new ParkingLotSystemException("Parking Lot Is Full");
    }

    //METHOD TO UNPARK THE GIVEN VEHICLE
    public boolean unParkTheVehicle(Object vehicleToUnPark) throws ParkingLotSystemException {
        if (vehicle.contains(vehicleToUnPark)) {
            vehicle.remove(vehicleToUnPark);
            return true;
        }
        throw new ParkingLotSystemException("Vehicle Is Not Parked Here");
    }
}