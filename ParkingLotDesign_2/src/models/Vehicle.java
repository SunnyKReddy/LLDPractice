package models;

public class Vehicle {
    private String vehicleNumber;
    private String vehicleBrandModel;
    private VehicleType vehicleType;
    private Status vehicleStatus;
    private int id;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleBrandModel() {
        return vehicleBrandModel;
    }

    public void setVehicleBrandModel(String vehicleBrandModel) {
        this.vehicleBrandModel = vehicleBrandModel;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
