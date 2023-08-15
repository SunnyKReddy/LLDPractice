package controller;

import models.Ticket;
import models.Vehicle;
import services.TicketGenerationService;

public class TicketGenerationController {
    //private static TicketGenerationController ticketGenerationController;
    private Vehicle vehicle;
    private Ticket ticket;
    private static TicketGenerationService ticketGenerationService;

    public TicketGenerationController(Vehicle vehicle){
        this.vehicle = vehicle;
        this.ticketGenerationService = new TicketGenerationService(vehicle);
        //getGeneratedTicket();
    }

//    public static TicketGenerationController getTicketGenerationController(Vehicle vehicle){
//        if(ticketGenerationController == null){
//            TicketGenerationController.ticketGenerationController = new TicketGenerationController(vehicle);
//        }
//        return ticketGenerationController;
//    }
    public void getGeneratedTicket(){
        this.ticket = ticketGenerationService.generateTicket();
//        System.out.println("_______________________________________");
//        System.out.println("| Parking Ticket: ParkPlus 1");
//        System.out.println("| Vehicle Type: " + ticket.getVehicle().getVehicleType());
//        System.out.println("| Vehicle Number: " + ticket.getVehicle().getVehicleNumber());
//        System.out.println("| Entry Time: " + ticket.getEntryTime());
//        System.out.println("| PARKING SPOT: " + ticket.getAllocatedParkingSpot().getSpotNo());
//        System.out.println("_______________________________________ ");
        System.out.println("_______________________________________");
        System.out.println("| Parking Ticket: ParkPlus 1");
        System.out.println("| Vehicle Type: " + ticket.getVehicle().getVehicleType());
        System.out.println("| Vehicle Number: " + ticket.getVehicle().getVehicleNumber());
        System.out.println("| Entry Time: " + ticket.getEntryTime());
        System.out.println("| PARKING SPOT: " + ticket.getAllocatedParkingSpot().getSpotNo());
        System.out.println("_______________________________________ ");
    }

}
