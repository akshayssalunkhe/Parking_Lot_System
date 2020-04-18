package com.bridgelabzs;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {

    List<Object> vehicle = new ArrayList<Object>();

    //VARIABLE
    int parkingLotCapacity = 5;
    public boolean isParkingFull;
    ParkingLotInformationSubscriber parkingLotInformationSubscriber;

    //CONSTRUCTOR
    public ParkingLotSystem() {
        parkingLotInformationSubscriber = new ParkingLotInformationSubscriber();
    }

    //METHOD TO PARK THE VEHICLE
    public boolean isPark(Object vehicleToPark) throws ParkingLotSystemException {
        if (this.vehicle.isEmpty()) {
            vehicle.add(vehicleToPark);
            return true;
        } else if (!this.vehicle.isEmpty() && (!this.vehicle.contains(vehicleToPark)) && (this.vehicle.size() < parkingLotCapacity)) {
            vehicle.add(vehicleToPark);
            return true;
        } else isParkingFull = true;
        parkingLotInformationSubscriber.notifyParkingStatus(true);
        return true;
    }

    //METHOD TO UNPARK THE GIVEN VEHICLE
    public boolean unParkTheVehicle(Object vehicleToUnPark) throws ParkingLotSystemException {
        if (vehicle.contains(vehicleToUnPark)) {
            vehicle.remove(vehicleToUnPark);
            parkingLotInformationSubscriber.notifyParkingStatus(false);
            return true;
        }
        throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.VEHICLE_NOT_PARK_HERE, "Vehicle Is Not Parked Here");
    }
}