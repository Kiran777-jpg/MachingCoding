package parkinglot;

import parkinglot.controllers.TicketController;
import parkinglot.dtos.IssueTicketRequestDto;
import parkinglot.dtos.IssueTicketResponseDto;
import parkinglot.factories.ParkingSpotAssignmentStrategyFactory;
import parkinglot.models.Ticket;
import parkinglot.models.enums.ParkingSpotStrategyType;
import parkinglot.repositories.GateRepository;
import parkinglot.repositories.VehicleRepository;
import parkinglot.services.TicketService;
import parkinglot.strategies.ParkingSpotAssingmentStrategy;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingSpotAssingmentStrategy parkingSpotAssingmentStrategy = ParkingSpotAssignmentStrategyFactory
                .getParkingSpotStrategy(ParkingSpotStrategyType.NEAREST);
        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingSpotAssingmentStrategy);
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setGateId(123L);
        requestDto.setOperatorId(345L);
        requestDto.setOwnerName("John");
        requestDto.setVehicleNumber("DUBAI777");

        IssueTicketResponseDto responseDto = ticketController.issueTicket(requestDto);
        Ticket ticket = responseDto.getTicket();
    }
}
