package models;

public class Payment {
    private Bill bill;
    private PaymentType paymentType;
    private String transactionId;
    private Status PaymentStatus;
    private int id;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Status getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(Status paymentStatus) {
        PaymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
