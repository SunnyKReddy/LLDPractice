package models;

import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> parkingSpots;
    private String floorNo;
    private Status floorStatus;
    private int id;

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public Status getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(Status floorStatus) {
        this.floorStatus = floorStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
