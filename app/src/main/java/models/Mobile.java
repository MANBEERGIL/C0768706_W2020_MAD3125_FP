package models;

import java.util.Date;

public class Mobile extends Bill{
    private String mobileManufacturerName;
    private  String planName;
    private String mobileNumber;
    private int internetGbUsed;
    private int minuteUsed;

    public Mobile(String billId,Date billDate,billType billType,String mobileManufacturerName, String planName, String mobileNumber, int internetGbUsed,int minuteUsed) {
        super(billId,billDate,billType);
        this.mobileManufacturerName = mobileManufacturerName;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.internetGbUsed = internetGbUsed;
        this.minuteUsed = minuteUsed;
        this.totalBillAmount = calculateBill();
    }


@Override

    public Double calculateBill() {
        this.totalBillAmount = ((double)this.minuteUsed*3.00) + ((double)this.internetGbUsed*2.5);
         return this.totalBillAmount;
    }

    public Mobile(String billId, Date billDate, billType billType) {
        super(billId, billDate, billType);
    }

    public String getMobileManufacturerName() {
        return mobileManufacturerName;
    }

    public void setMobileManufacturerName(String mobileManufacturerName) {
        this.mobileManufacturerName = mobileManufacturerName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getInternetGbUsed() {
        return internetGbUsed;
    }

    public void setInternetGbUsed(int internetGbUsed) {
        this.internetGbUsed = internetGbUsed;
    }
}
