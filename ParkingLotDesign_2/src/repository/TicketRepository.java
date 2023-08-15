package repository;

import exceptions.TicketNotFoundException;
import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<String, Ticket> ticketRepo;
    public TicketRepository(){
        ticketRepo = new HashMap<String, Ticket>();
    }

    public Ticket get(String vehicleNo){
        Ticket ticket = ticketRepo.get(vehicleNo);
        if(ticket == null) {
            throw new TicketNotFoundException("Ticket with given id not found: " + vehicleNo);
        }
        return ticket;
    }

    public void put(Ticket ticket){
        ticketRepo.put(ticket.getVehicle().getVehicleNumber(), ticket);
        System.out.println("Ticket alloted to " + ticket.getVehicle().getVehicleNumber() + " successfully.");
    }

}
