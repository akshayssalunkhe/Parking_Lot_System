package com.bridgelabzs;

public class AirportSecurity implements IParkingLotObserver {

    //FIELD
    private boolean isParkingFull;

    @Override
    public void updateParkingLotStatus(boolean parkingLotStatus) {
        this.isParkingFull = parkingLotStatus;
        System.out.println("AIRPORT SECURITY:PARKING LOT IS FULL");
    }
}
