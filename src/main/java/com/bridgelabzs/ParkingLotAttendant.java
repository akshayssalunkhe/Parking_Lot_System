package com.bridgelabzs;

public class ParkingLotAttendant {

    ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
    public Integer PARKING_SLOT_SIZE = 5;
    private boolean isParkingFull;
    public IParkingLotInFormation parkingLotInformationSubscriber;

    public ParkingLotAttendant() {
        Driver driver;
        parkingLotInformationSubscriber = new ParkingLotInformationSubscriber();
    }

    public Integer getParkingSlot() {
        return this.PARKING_SLOT_SIZE;
    }

    //METHOD TO PARK THE VEHICLE
    public boolean isPark(Integer parkingSlotNumber, Object vehicleToPark) throws ParkingLotSystemException {
        if (parkingLotOwner.parkingLotMap.isEmpty()) {
            parkingLotOwner.parkingLotMap.put(parkingSlotNumber, vehicleToPark);
            return true;
        } else if (!parkingLotOwner.parkingLotMap.isEmpty() && (!parkingLotOwner.parkingLotMap.containsKey(parkingSlotNumber)) && (parkingLotOwner.parkingLotMap.size() < getParkingSlot())) {
            parkingLotOwner.parkingLotMap.put(parkingSlotNumber, vehicleToPark);
            return true;
        } else isParkingFull = true;
        parkingLotInformationSubscriber.notifyParkingStatus(true);
        return true;
    }

    //METHOD TO UNPARK THE GIVEN VEHICLE
    public boolean unParkTheVehicle(Integer key) throws ParkingLotSystemException {
        if (parkingLotOwner.parkingLotMap.containsKey(key)) {
            parkingLotOwner.parkingLotMap.remove(key);
            parkingLotInformationSubscriber.notifyParkingStatus(false);
            return true;
        }
        throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.VEHICLE_NOT_PARK_HERE, "Vehicle Is Not Parked Here");
    }
}