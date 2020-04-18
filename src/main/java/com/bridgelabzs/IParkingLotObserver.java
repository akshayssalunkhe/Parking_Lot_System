package com.bridgelabzs;

public interface IParkingLotObserver {
    void updateParkingLotStatus(boolean parkingLotStatus) throws ParkingLotSystemException;
}