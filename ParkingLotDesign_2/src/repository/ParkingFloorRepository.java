package repository;

import exceptions.ParkingFloorNotFoundException;
import models.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private static ParkingFloorRepository parkingFloorRepository;
    private static Map<String, ParkingFloor> parkingFloorRepo;

    private ParkingFloorRepository(){
        parkingFloorRepo = new HashMap<String, ParkingFloor>();
    }

    public static ParkingFloorRepository getParkingFloorRepository(){
        if(parkingFloorRepository == null){
            parkingFloorRepository = new ParkingFloorRepository();
        }
        return parkingFloorRepository;
    }

    public ParkingFloor get(String parkingFloorId){
        ParkingFloor parkingFloor = parkingFloorRepo.get(parkingFloorId);
        if(parkingFloor == null){
            throw new ParkingFloorNotFoundException("ParkingFloor not found with given ID :" + parkingFloorId);
        }
        return parkingFloor;
    }

    public void put(ParkingFloor parkingFloor){
        parkingFloorRepo.put(parkingFloor.getFloorNo(), parkingFloor);
        System.out.println("ParkingFloor " + parkingFloor.getFloorNo() + " added successfully!");
    }
}
