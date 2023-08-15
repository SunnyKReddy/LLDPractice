package models;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gatesEntryExit;
    private int parkingCapacity;
    private String parkingLotNameAddress;
    private int id;
    private Status lotStatus;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGatesEntryExit() {
        return gatesEntryExit;
    }

    public void setGatesEntryExit(List<Gate> gatesEntryExit) {
        this.gatesEntryExit = gatesEntryExit;
    }

    public int getParkingCapacity() {
        return parkingCapacity;
    }

    public void setParkingCapacity(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
    }

    public String getParkingLotNameAddress() {
        return parkingLotNameAddress;
    }

    public void setParkingLotNameAddress(String parkingLotNameAddress) {
        this.parkingLotNameAddress = parkingLotNameAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getLotStatus() {
        return lotStatus;
    }

    public void setLotStatus(Status lotStatus) {
        this.lotStatus = lotStatus;
    }
}
