package repository;

import exceptions.ParkingLotNotFoundException;
import models.ParkingLot;
import models.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private static ParkingLotRepository parkingLotRepository;
    private static Map<Integer, ParkingLot> parkingLotRepo;

    private ParkingLotRepository(){
        parkingLotRepo = new HashMap<Integer, ParkingLot>(); //<String parkingLotName, ParkingLot parkingLot>
    }
    public static ParkingLotRepository getParkingLotRepository(){
        if(ParkingLotRepository.parkingLotRepository == null) {
            parkingLotRepository = new ParkingLotRepository();
        }
        return parkingLotRepository;
    }

    public ParkingLot get(int parkingLotId){
        ParkingLot parkingLot = parkingLotRepo.get(parkingLotId);
        if(parkingLot == null){
            throw new ParkingLotNotFoundException("ParkingLot not found for the given ID: " + parkingLotId);
        }
        return parkingLot;
    }

    public void put(ParkingLot parkingLot){
        parkingLotRepo.put(parkingLot.getId(), parkingLot);
        System.out.println("ParkingLot " + parkingLot.getParkingLotNameAddress() + " has been added successfully!");
    }

    public static Map<Integer, ParkingLot> getParkingLotRepo() {
        return parkingLotRepo;
    }

    public static void setParkingLotRepo(Map<Integer, ParkingLot> parkingLotRepo) {
        ParkingLotRepository.parkingLotRepo = parkingLotRepo;
    }

}
