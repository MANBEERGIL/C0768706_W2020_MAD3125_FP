package models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable {

    public enum billType{
        HYDRO,INTERNET,MOBILE
    }

    public Double totalBillAmount;
    private  String billId;
    private String billDate;
    private billType billType;



    public Bill(String billId, String billDate, billType billType) {
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

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public billType getBillType() {
        return billType;
    }

    public void setBillType(billType billType) {
        this.billType = billType;
    }

    public Double getTotalBillAmount() {
        return totalBillAmount;
    }

    public void setTotalBillAmount(Double totalBillAmount) {
        this.totalBillAmount = totalBillAmount;
    }


  public Double calculateBill(){
        double intialAmount = 0.0;
        return intialAmount;
   }


}
