package models;

import java.util.ArrayList;

public class Customers {
   private String customerId;
   private String firstName;
   private  String lastName;
   private String fullName;
   private String email;
   private ArrayList<Bill> bills;
   private  Double totalBillToPAY;

    public Customers(String customerId, String firstName, String lastName, String fullName, String email, ArrayList<Bill>bills, Double totalBillToPAY) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.email = email;
       this.bills = bills;
        this.totalBillToPAY = totalBillToPAY;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public Double getTotalBillToPAY() {
        return totalBillToPAY;
    }

    public void setTotalBillToPAY(Double totalBillToPAY) {
        this.totalBillToPAY = totalBillToPAY;
    }
    private String fullName(){
        String fullName ;
        fullName = firstName + "" + lastName;
        return  fullName;
    }
}
