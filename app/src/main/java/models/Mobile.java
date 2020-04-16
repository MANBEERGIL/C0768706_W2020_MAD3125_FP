package models;

import java.util.Date;

public class Mobile extends Bill{
    private String mobileManufacturerName;
    private  String planName;
    private int mobileNumber;
    private int internetGbUsed;

    public Mobile(String billId,Date billDate,String billType,String mobileManufacturerName, String planName, int mobileNumber, int internetGbUsed) {
        super(billId,billDate,billType);
        this.mobileManufacturerName = mobileManufacturerName;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.internetGbUsed = internetGbUsed;
    }

    public Mobile(String billId, Date billDate, String billType) {
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

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getInternetGbUsed() {
        return internetGbUsed;
    }

    public void setInternetGbUsed(int internetGbUsed) {
        this.internetGbUsed = internetGbUsed;
    }
}
