package parkinglot.services;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.models.Gate;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.models.enums.VehicleType;
import parkinglot.repositories.GateRepository;
import parkinglot.repositories.VehicleRepository;

import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
    }
    public Ticket issueTicket(String vehicleNumber, String ownerNumber, Long gateId, Long operatorId) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        Optional<Gate> optionalGate = gateRepository.findByGateId(gateId);
        if(optionalGate.isEmpty()) {
            throw new GateNotFoundException("Invalid Gate Id");
        }

        Gate gate = optionalGate.get();
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle = null;
        if(optionalVehicle.isEmpty()) {
            Vehicle vehicle1 = new Vehicle();
            vehicle1.setNumber(vehicleNumber);
            vehicle1.setOwnerName(ownerNumber);
            vehicle1.setVehicleType(VehicleType.SUV);
            vehicle = vehicleRepository.save(vehicle1);
        } else {
            vehicle = optionalVehicle.get();
        }
        ticket.setVehicle(vehicle);
        return null;
    }
}
