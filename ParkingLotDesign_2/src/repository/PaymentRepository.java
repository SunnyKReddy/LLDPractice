package repository;

import exceptions.ParkingSpotNotFoundException;
import exceptions.PaymentNotFoundException;
import models.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {
    private Map<String, Payment> paymentRepo;

    PaymentRepository(){
        paymentRepo = new HashMap<String, Payment>();
    }
    public Payment get(String transactionId){
        Payment payment = paymentRepo.get(transactionId);
        if(payment == null){
            throw new PaymentNotFoundException("Payment with given transaction id not found: " + transactionId);
        }
        return payment;
    }

    public void put(Payment payment){
        paymentRepo.put(payment.getTransactionId(), payment);
        System.out.println("Payment details " + payment.getTransactionId() + "added successfully.");
    }
}
