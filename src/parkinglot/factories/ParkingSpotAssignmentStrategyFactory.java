package parkinglot.factories;

import parkinglot.models.enums.ParkingSpotStrategyType;
import parkinglot.strategies.*;

public class ParkingSpotAssignmentStrategyFactory {
    public static ParkingSpotAssingmentStrategy getParkingSpotStrategy(ParkingSpotStrategyType parkingSpotStrategyType) {
        if(parkingSpotStrategyType.equals(ParkingSpotStrategyType.NEAREST)) {
            return new NearestParkingSpotAssingmentStrategy();
        } else if(parkingSpotStrategyType.equals(ParkingSpotStrategyType.EV)) {
            return new EVParkingSpotAssingmentStrategy();
        } else if(parkingSpotStrategyType.equals(ParkingSpotStrategyType.VIP)) {
            return new VIPParkingSpotAssingmentStrategy();
        }
        return new CheapestParkingSpotAssingmentStrategy();
    }
}
