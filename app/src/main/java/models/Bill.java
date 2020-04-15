package models;

import java.util.Date;

public class Bill {

    private  String billId;
    private Date billDate;
    private String billType;
    private  String totalBillAmount;



    public Bill(String billId, String billType, Date billDate) {
        this.billId = billId;
        this.billDate = billDate;
        this.billType = billType;


    }


    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
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
