package com.bridgelabzs.observerpattern;

public interface ParkingLotInformer {
    void addObserver(ParkingLotObserver lotObserver);

    void notifyParkingStatus(boolean parkingStatus);
}
