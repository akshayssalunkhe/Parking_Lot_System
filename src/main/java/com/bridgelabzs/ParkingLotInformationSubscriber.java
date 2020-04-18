package com.bridgelabzs;

public class ParkingLotInformationSubscriber implements IParkingLotInFormation {

    //FIELDS
    private ParkingLotOwner parkingLotOwner;
    private AirportSecurity airportSecurity;

    //CONSTRUCTOR
    public ParkingLotInformationSubscriber() {
        airportSecurity = new AirportSecurity();
        parkingLotOwner = new ParkingLotOwner();
    }

    @Override
    public void notifyParkingStatus(boolean status) throws ParkingLotSystemException {
        airportSecurity.updateParkingLotStatus(status);
        parkingLotOwner.updateParkingLotStatus(status);
    }
}