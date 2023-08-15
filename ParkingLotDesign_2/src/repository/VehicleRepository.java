package repository;

import exceptions.VehicleNotFoundException;
import models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Map<String, Vehicle> vehicleRepo;

    VehicleRepository(){
        vehicleRepo = new HashMap<String, Vehicle>();
    }

    public Vehicle get(String vehicleNo){
        Vehicle vehicle = vehicleRepo.get(vehicleNo);
        if(vehicle == null) {
            throw new VehicleNotFoundException("Vehicle with given number not found: " + vehicleNo);
        }
        return vehicle;
    }

    public void put(Vehicle vehicle){
        vehicleRepo.put(vehicle.getVehicleNumber(), vehicle);
    }
}
