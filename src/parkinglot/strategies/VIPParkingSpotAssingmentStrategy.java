package parkinglot.strategies;

import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSpot;
import parkinglot.models.Vehicle;

public class VIPParkingSpotAssingmentStrategy implements ParkingSpotAssingmentStrategy{

    @Override
    public ParkingSpot assignParkingSpot(ParkingLot parkingLot, Vehicle vehicle) {
        return new ParkingSpot();
    }
}
