package com.bridgelabzs.observerpattern;

public class AirportSecurity implements ParkingLotObserver {
    private Boolean isParkingFull;

    @Override
    public void updateParkingStatus(boolean parkingStatus) {
        isParkingFull = parkingStatus;
    }
}