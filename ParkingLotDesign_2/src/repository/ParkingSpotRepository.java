package repository;

import exceptions.ParkingSpotNotFoundException;
import models.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository {
    private static ParkingSpotRepository parkingSpotRepository;
    private static Map<String, ParkingSpot> availableParkingSpotsRepo;
    private static Map<String, ParkingSpot> parkingSpotRepo;

    public static Map<String, ParkingSpot> getParkingSpotRepo() {
        return parkingSpotRepo;
    }

    public static Map<String, ParkingSpot> getAvailableParkingSpotsRepo() {
        return availableParkingSpotsRepo;
    }

    private ParkingSpotRepository(){
        parkingSpotRepo = new HashMap<String, ParkingSpot>();
        availableParkingSpotsRepo = new HashMap<String, ParkingSpot>();
    }

    public static ParkingSpotRepository getParkingSpotRepository(){
        if(parkingSpotRepository == null){
            parkingSpotRepository = new ParkingSpotRepository();
        }
        return parkingSpotRepository;
    }

    public ParkingSpot get(String parkingSpotId){
        ParkingSpot parkingSpot = parkingSpotRepo.get(parkingSpotId);
        if(parkingSpot == null){
            throw new ParkingSpotNotFoundException("ParkingSpot with provided Id not found: " + parkingSpotId);
        }
        return parkingSpot;
    }

    public void put(ParkingSpot parkingSpot){
        parkingSpotRepo.put(parkingSpot.getSpotNo(), parkingSpot);
        availableParkingSpotsRepo.put(parkingSpot.getSpotNo(), parkingSpot);
        System.out.println("ParkingSpot " + parkingSpot.getSpotNo() + " Spot Type: " + parkingSpot.getAllowedVehicletype() + " added successfully!");
    }

    public void removeAvailableParkingSpot(String parkingSpotId){
        availableParkingSpotsRepo.remove(parkingSpotId);
    }
}
