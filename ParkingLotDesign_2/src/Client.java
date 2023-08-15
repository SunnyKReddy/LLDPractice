import controller.TicketGenerationController;
import exceptions.ParkingFloorNotFoundException;
import models.*;
import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        int parkingLotStatus = 0;
        int vehicleID = 1;
        Scanner scanner = new Scanner(System.in);
        //Initializing ParkingLot
        Client.initializeParkingLot();
        TicketGenerationController ticketGenerationController;
        while(parkingLotStatus != -1){
            Vehicle vehicle = new Vehicle();
            System.out.println("Enter Vehicle Number: ");
            String vehicleNumber = scanner.next();
            System.out.println("Enter Vehicle type");
            VehicleType vehicleType = VehicleType.valueOf(scanner.next().toUpperCase());
            //System.out.println("Enter Vehicle ID: ");
            vehicleID++;
            System.out.println("Vehicle Brand Model: ");
            String vehicleBrandModel = scanner.next();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setId(vehicleID);
            vehicle.setVehicleBrandModel(vehicleBrandModel);
            ticketGenerationController = new TicketGenerationController(vehicle);
            ticketGenerationController.getGeneratedTicket();
            //scanner.next();
            System.out.println("Press '-1' to exit: ");
            parkingLotStatus = scanner.nextInt();
        }
//        Vehicle vehicle = new Vehicle();
//        vehicle.setVehicleNumber("AP26GZ2515");
//        vehicle.setVehicleType(VehicleType.CAR);
//        vehicle.setId(1);
//        vehicle.setVehicleBrandModel("YAMAHA FZ-X");
//        TicketGenerationController ticketGenerationController = new TicketGenerationController(vehicle);
    }
    public static void initializeParkingLot(){
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();
        Gate entryGate = new Gate();
        Gate exitGate = new Gate();
        //ParkingFloor parkingFloor = new ParkingFloor();
        //ParkingSpot parkingSpot = new ParkingSpot();

        //initializing repositories
        ParkingLotRepository parkingLotRepository = ParkingLotRepository.getParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = ParkingFloorRepository.getParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = ParkingSpotRepository.getParkingSpotRepository();

        //User Defining ParkingFloor count and ParkingSpot count per floor.
        System.out.println("Enter No.of ParkingFloors of a ParkingLot: ");
        int noOfFloors = scanner.nextInt();
        System.out.println("Enter No.of ParkingSpots supported per floor: ");
        int noOfParkingSpotsPerFloor = scanner.nextInt();
        String floorNo, floorStatus, spotNo;
        int floorId;
        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        for(int i = 1; i <= noOfFloors; i++){
            ParkingFloor parkingFloor = new ParkingFloor();
            floorNo = "park- " + i;
            parkingFloor.setFloorNo(floorNo);
            parkingFloor.setFloorStatus(Status.ACTIVE);
            parkingFloor.setId(i);
            List<ParkingSpot> parkingSpotList = new ArrayList<>();
            for(int j = 1; j <= noOfParkingSpotsPerFloor; j++){
                ParkingSpot parkingSpot = new ParkingSpot();
                spotNo = floorNo + "-" + j;
                System.out.println("Spot No is: " + spotNo);
                parkingSpot.setSpotNo(spotNo);
                parkingSpot.setSpotStatus(Status.ACTIVE);
                if(j <= noOfParkingSpotsPerFloor/4 && i == 1) {
                    parkingSpot.setAllowedVehicletype(VehicleType.EVBIKE);
                } else if(j > noOfParkingSpotsPerFloor/4 && i == 1) {
                    parkingSpot.setAllowedVehicletype(VehicleType.BIKE);
                } else if (i > 2) {
                    parkingSpot.setAllowedVehicletype(VehicleType.CAR);
                } else if (i == 2 & j <= noOfParkingSpotsPerFloor/2) {
                    parkingSpot.setAllowedVehicletype(VehicleType.EVCAR);
                } else if (i == 2 & j > noOfParkingSpotsPerFloor/2) {
                    parkingSpot.setAllowedVehicletype(VehicleType.CAR);
                }
                //parkingSpot.setAllowedVehicletype(VehicleType.BIKE);
                parkingSpot.setId(i + j * 10);

                //updating ParkingSpot Repo
                parkingSpotRepository.put(parkingSpot);
                parkingSpotList.add(parkingSpot);
            }
            parkingFloorRepository.put(parkingFloor);
            parkingFloor.setParkingSpots(parkingSpotList);
        }

        //----------------------------------------------------------

        //General Attributes of ParkingSpot - considering one spot
//        parkingSpot.setSpotNo("1A001");
//        parkingSpot.setSpotStatus(Status.ACTIVE);
//        parkingSpot.setAllowedVehicletype(VehicleType.BIKE);
//        parkingSpot.setId(1);

        //General Attributes of ParkingFloor
//        parkingFloor.setFloorNo("A");
//        parkingFloor.setFloorStatus(Status.ACTIVE);
//        parkingFloor.setId(1);
//        List<ParkingSpot> parkingSpotList = new ArrayList<>();
//        parkingSpotList.add(parkingSpot);
//        parkingFloor.setParkingSpots(parkingSpotList);

        //General attributes of Gate
        //EntryGate
        entryGate.setGateNo("Entry 1");
        entryGate.setGateStatus(Status.ACTIVE);
        entryGate.setGateType(GateType.ENTRY);
        //ExitGate
        exitGate.setGateNo("Exit 1");
        exitGate.setGateStatus(Status.ACTIVE);
        exitGate.setGateType(GateType.EXIT);

        //General attributes of ParkingLot
        parkingLot.setLotStatus(Status.ACTIVE);
        parkingLot.setParkingCapacity(100);
        parkingLot.setParkingLotNameAddress("ParkPlus 1,Kormangala, Bangalore");
        parkingLot.setId(1);
        //List<ParkingFloor> parkingFloorList = new ArrayList<>();
        //parkingFloorList.add(parkingFloor);
        parkingLot.setParkingFloors(parkingFloorList);
        List<Gate> entryExitGates = new ArrayList<>();
        entryExitGates.add(entryGate);
        entryExitGates.add(exitGate);
        parkingLot.setGatesEntryExit(entryExitGates);
        System.out.println("ParkingLot initialized");
        //parkingSpotRepository.put(parkingSpot);
        //parkingFloorRepository.put(parkingFloor);
        parkingLotRepository.put(parkingLot);
        //System.out.println(parkingLotRepository.get(1).getParkingLotNameAddress());

        //System.out.println(parkingFloorRepository.get("A").getParkingSpots().get(0).getAllowedVehicletype());
    }
}
