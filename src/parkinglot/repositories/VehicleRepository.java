package parkinglot.repositories;

import parkinglot.models.Vehicle;

import java.util.Optional;

public class VehicleRepository {

    // output vehicle object has id present
    public Vehicle save(Vehicle vehicle) {
        return null;
    }

    public Optional<Vehicle> findVehicleById(Long id) {
        return Optional.empty();
    }

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
        return Optional.empty();
    }
}
