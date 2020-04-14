package models;

public class Mobile {
    private String mobileManufacturerName;
    private  String planName;
    private int mobileNumber;
    private int internetGbUsed;

    public Mobile(String mobileManufacturerName, String planName, int mobileNumber, int internetGbUsed) {
        this.mobileManufacturerName = mobileManufacturerName;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.internetGbUsed = internetGbUsed;
    }
}
