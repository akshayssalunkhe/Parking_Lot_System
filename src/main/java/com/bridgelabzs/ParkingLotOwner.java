package com.bridgelabzs;

public class ParkingLotOwner implements IParkingLotObserver {

    //FIELDS
    boolean isParkingFull;
    ParkingLotSystem parkingLotSystem;

    @Override
    public void updateParkingLotStatus(boolean parkingLotStatus) {
        parkingLotSystem = new ParkingLotSystem();
        if (parkingLotStatus == true) {
            this.isParkingFull = parkingLotStatus;
            System.out.println("PARKING LOT OWNER:PARKING_LOT_IS_FULL");
        }
        parkingLotSystem.isParkingFull = false;
    }
}
