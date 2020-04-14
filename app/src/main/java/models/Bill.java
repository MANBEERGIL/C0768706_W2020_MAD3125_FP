package models;

public class Bill {

    private  String billId;
    private  String billDate;
    private String billType;
    private  String totalBillAmount;

    public Bill(String billId, String billDate, String billType, String totalBillAmount) {
        this.billId = billId;
        this.billDate = billDate;
        this.billType = billType;
        this.totalBillAmount = totalBillAmount;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getTotalBillAmount() {
        return totalBillAmount;
    }

    public void setTotalBillAmount(String totalBillAmount) {
        this.totalBillAmount = totalBillAmount;
    }




}
