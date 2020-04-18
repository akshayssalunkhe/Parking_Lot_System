package com.bridgelabzs;

public class ParkingLotSystemException extends Exception {
    //ENUM
    public enum ExceptionType {VEHICLE_NOT_PARK_HERE, PARKING_LOT_IS_FULL};

    public ExceptionType type;
    private final String message;

    //CONSTRUCTOR
    public ParkingLotSystemException(ExceptionType type, String message) {
        super(message);
        this.message = message;
    }
}