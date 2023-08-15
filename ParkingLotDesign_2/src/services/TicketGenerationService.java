package services;

import controller.TicketGenerationController;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import repository.ParkingSpotRepository;
import repository.TicketRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TicketGenerationService {
    //private static TicketGenerationService ticketGenerationService;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;
    //private static ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
    private static TicketRepository ticketRepository = new TicketRepository();
    public TicketGenerationService(Vehicle vehicle){
        this.vehicle = vehicle;
    }

//    public static TicketGenerationService getTicketGenerationService(Vehicle vehicle){
//        if(ticketGenerationService == null){
//            ticketGenerationService = new TicketGenerationService(vehicle);
//        }
//        return ticketGenerationService;
//    }
    public Ticket generateTicket(){
        int size, randomInteger;
        String randomParkingSlotId = null;
        Ticket ticket = new Ticket();
        ParkingSpot parkingSpot = null;
        //TODO: get available parking Spot and pass it.
        //Randomly picking suitable spot from availability list
        Set<String> parkingSpotRepoKeysSet = ParkingSpotRepository.getParkingSpotRepository().getAvailableParkingSpotsRepo().keySet();
        List<String> parkingSpotRepoKeysList = new ArrayList<>(parkingSpotRepoKeysSet);

        boolean slotNotFound = true;
        int slotIdentifyingCounter = 0;
        while(slotNotFound){
            System.out.println("Identifying suitable ParkingSpot: ");
            size = parkingSpotRepoKeysList.size();
            randomInteger = new Random().nextInt(size);

            randomParkingSlotId = parkingSpotRepoKeysList.get(randomInteger);
            if(slotIdentifyingCounter > size){
                System.out.println("ParkingSpot for the given Vehicle type is not vacant...");
                break;
            }
            slotIdentifyingCounter++;
            parkingSpot = ParkingSpotRepository.getParkingSpotRepository().get(randomParkingSlotId);
            if (parkingSpot.getAllowedVehicletype() == this.vehicle.getVehicleType()) {
                System.out.println("ParkingSpot identified: ");
                System.out.println(parkingSpot.getAllowedVehicletype() + " ->  " + parkingSpot.getSpotNo() + " ->  " + parkingSpot.getSpotStatus());
                slotNotFound = false;
                parkingSpot.setVehicle(this.vehicle);
                this.entryTime = LocalDateTime.now();
                ticket.setEntryTime(entryTime);
                ticket.setId(1);
                ticket.setVehicle(this.vehicle);
                ticket.setAllocatedParkingSpot(parkingSpot);
                ticketRepository.put(ticket);
                ParkingSpotRepository.getParkingSpotRepository().removeAvailableParkingSpot(randomParkingSlotId);
            }
        }
        //ParkingSpot parkingSpot = ParkingSpotRepository.getParkingSpotRepository().get(randomParkingSlotId);
//        parkingSpot.setVehicle(this.vehicle);
//        this.entryTime = LocalDateTime.now();
//        ticket.setEntryTime(entryTime);
//        ticket.setId(1);
//        ticket.setVehicle(this.vehicle);
//        ticket.setAllocatedParkingSpot(parkingSpot);
//        ticketRepository.put(ticket);
//        ParkingSpotRepository.getParkingSpotRepository().removeAvailableParkingSpot(randomParkingSlotId);

        return ticket;
    }
}
