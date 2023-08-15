package repository;

import exceptions.GateNotFoundException;
import models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private Map<String, Gate> gateRepo;

    public GateRepository(){
        gateRepo = new HashMap<String, Gate>();
    }

    public Gate get(String gateNo){
        Gate gate = gateRepo.get(gateNo);
        if(gate == null){
            throw new GateNotFoundException("Gate with given id not found: " + gateNo);
        }
        return gate;
    }

    public void put(Gate gate){
        gateRepo.put(gate.getGateNo(), gate);
        System.out.println("Gate " + gate.getGateNo() + " added successfully!");
    }
}
