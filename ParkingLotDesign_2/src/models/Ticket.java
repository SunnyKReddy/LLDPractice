package models;

import java.time.LocalDateTime;

public class Ticket {
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot allocatedParkingSpot;
    private int id;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpot getAllocatedParkingSpot() {
        return allocatedParkingSpot;
    }

    public void setAllocatedParkingSpot(ParkingSpot allocatedParkingSpot) {
        this.allocatedParkingSpot = allocatedParkingSpot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
