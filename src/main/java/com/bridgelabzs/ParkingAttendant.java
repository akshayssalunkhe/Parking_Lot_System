package com.bridgelabzs;

public class ParkingAttendant {
    ParkingLotSystem parkingLotSystem;

    //PARAMETRISED CONSTRUCTOR
    public ParkingAttendant(ParkingLotSystem parkingLotSystem) {
        this.parkingLotSystem = parkingLotSystem;
    }

    //METHOD TO PARK THE VEHICLE IN PARKING LOT
    public void parkVehicle(Vehicle vehicle) throws ParkingLotSystemException {
        if (parkingLotSystem.isVehicleParked(vehicle)) {
            throw new ParkingLotSystemException(ParkingLotSystemException.ExceptionType.VEHICLE_ALREADY_PARKED, "Vehicle is already parked");
        }
        String key = "VH " + parkingLotSystem.vehicleMap.size() + 1;
        parkingLotSystem.vehicleMap.put(key, vehicle);
    }

    //METHOD TO UNPARK THE VEHICLE FROM PARKING LOT
    public void unParkedVehicle(Vehicle vehicle) {
        parkingLotSystem.vehicleMap.entrySet().removeIf(entry -> vehicle.equals(entry.getValue()));
    }

    //METHOD TO GET THE POSITION IF VEHICLE IN PARKING LOT
    public String getVehiclePosition(Vehicle vehicle) {
        return parkingLotSystem.vehicleMap.keySet().stream()
                .filter(key -> vehicle.equals(parkingLotSystem.vehicleMap.get(key)))
                .findFirst()
                .get();
    }
}