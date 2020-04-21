package com.bridgelabzs;

public class Driver {

    public IParkingLotInFormation parkingLotInformationSubscriber;
    public ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
    public Driver driver;
    Object vehicle = new Object();

    public Driver() {
        parkingLotInformationSubscriber = new ParkingLotInformationSubscriber();
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
    }

    //METHOD TO UNPARK THE VEHICLE
    public boolean unParkTheVehicle(Object vehicle) throws ParkingLotSystemException {
        parkingLotOwner.parkingLotMap.containsKey(vehicle);
        if (parkingLotOwner.parkingLotMap.isEmpty()) {
            parkingLotOwner.parkingLotMap.remove(vehicle);
            parkingLotInformationSubscriber.notifyParkingStatus(false);
            return true;
        }
        throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.VEHICLE_NOT_PARK_HERE, "Vehicle Is Not Parked Here");
    }
}