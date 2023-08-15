package models;

public class Gate {
    private GateType gateType;
    //private String Operator;
    private String gateNo;
    private Status gateStatus;

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public String getGateNo() {
        return gateNo;
    }

    public void setGateNo(String gateNo) {
        this.gateNo = gateNo;
    }

    public Status getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(Status gateStatus) {
        this.gateStatus = gateStatus;
    }
}
