package com.bridgelabzs;

public class ParkingLotSystemException extends Exception {
    private final String message;

    //CONSTRUCTOR
    public ParkingLotSystemException(String message) {
        this.message = message;
    }
}