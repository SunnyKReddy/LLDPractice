package repository;

import exceptions.BillNotFoundException;
import models.Bill;

import java.util.HashMap;
import java.util.Map;

public class BillRepository {
    private Map<String, Bill> billRepo;
    BillRepository(){
        billRepo = new HashMap<String, Bill>();
    }
    public Bill get(String vehicleNo){
        Bill bill = billRepo.get(vehicleNo);
        if(bill == null) {
            throw new BillNotFoundException("Bill with given id not found: " + vehicleNo);
        }
        return bill;
    }
    public void put(Bill bill){
        billRepo.put(bill.getTicket().getVehicle().getVehicleNumber(), bill);
        System.out.println("Bill for " + bill.getTicket().getVehicle().getVehicleNumber() + " added successfully.");
    }
}
