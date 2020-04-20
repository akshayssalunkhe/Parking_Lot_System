package com.bridgelabzs;

import java.util.HashMap;

public class ParkingLotAttendant {

    ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
    HashMap<Integer, Object> parkingLotMap = new HashMap<Integer, Object>();

    public Integer PARKING_SLOT_SIZE = 5;
//    public Integer ParkingSlotNumber = parkingLotOwner.generateParkingSlotNumber();
//    private Object vehicle;
    private boolean isParkingFull;
    private IParkingLotInFormation parkingLotInformationSubscriber;

    public Integer getParkingSlot() {
        return this.PARKING_SLOT_SIZE;
    }

    //METHOD TO PARK THE VEHICLE
    public boolean isPark(Integer parkingSlotNumber, Object vehicleToPark) throws ParkingLotSystemException {
        if (parkingLotMap.isEmpty()) {
            parkingLotMap.put(parkingSlotNumber, vehicleToPark);
            return true;
        } else if (!this.parkingLotMap.isEmpty() && (!this.parkingLotMap.containsKey(parkingSlotNumber)) && (this.parkingLotMap.size() < getParkingSlot())) {
            parkingLotMap.put(parkingSlotNumber, vehicleToPark);
            return true;
        } else isParkingFull = true;
        parkingLotInformationSubscriber.notifyParkingStatus(true);
        return true;
    }

    //METHOD TO UNPARK THE GIVEN VEHICLE
    public boolean unParkTheVehicle(Integer key) throws ParkingLotSystemException {
        if (parkingLotMap.containsKey(key)) {
            parkingLotMap.remove(key);
            parkingLotInformationSubscriber.notifyParkingStatus(false);
            return true;
        }
        throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.VEHICLE_NOT_PARK_HERE, "Vehicle Is Not Parked Here");
    }
}