package models;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleType allowedVehicletype;
    private String spotNo;
    private Status spotStatus;
    private int id;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getAllowedVehicletype() {
        return allowedVehicletype;
    }

    public void setAllowedVehicletype(VehicleType allowedVehicletype) {
        this.allowedVehicletype = allowedVehicletype;
    }

    public String getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(String spotNo) {
        this.spotNo = spotNo;
    }

    public Status getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(Status spotStatus) {
        this.spotStatus = spotStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
