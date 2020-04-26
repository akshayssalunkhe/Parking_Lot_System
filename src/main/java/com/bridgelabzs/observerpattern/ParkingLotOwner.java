package com.bridgelabzs.observerpattern;

import com.bridgelabzs.parkinglotsystem.ParkingLotSystem;

public class ParkingLotOwner implements ParkingLotObserver {

    //FIELDS
    ParkingLotSystem parkingLotSystem;
    private boolean isParkingFull;

    public ParkingLotOwner() {
        parkingLotSystem = new ParkingLotSystem();
    }

    @Override
    public void updateParkingStatus(boolean parkingStatus) {
        isParkingFull = parkingStatus;
    }
}