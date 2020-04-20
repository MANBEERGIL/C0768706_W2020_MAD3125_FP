package models;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Customers implements Parcelable {
   private String customerId;
   private String firstName;
   private  String lastName;
   private String fullName;
   private String email;
   private String birthDate;
   private String gender;
   private HashMap<String,Bill>billHashMap = new HashMap<String, Bill>();
   private ArrayList<Bill> bills;
   private  Double totalBillToPay = 0.0;

    public Customers(String customerId, String firstName, String lastName, String email,String gender,String dob) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate= dob;
        this.gender = gender;
    }

   

    public HashMap<String, Bill> getBillHashMap() {
        return billHashMap;
    }

    public void setBillHashMap(HashMap<String, Bill> billHashMap) {
        this.billHashMap = billHashMap;
    }

    public Customers(Parcel in) {
       this.customerId = in.readString();
       this.firstName = in.readString();
       this.lastName = in.readString();
       this.fullName = in.readString();
       this.email = in.readString();
       this.billHashMap = in.readHashMap(Bill.class.getClassLoader());
       this.totalBillToPay = (Double) in.readValue(Double.class.getClassLoader());

    }

    public static final Creator<Customers> CREATOR = new Creator<Customers>() {
        @Override
        public Customers createFromParcel(Parcel in) {
            return new Customers(in);
        }

        @Override
        public Customers[] newArray(int size) {
            return new Customers[size];
        }
    };

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public Double getTotalBillToPay() {
        return totalBillToPay;
    }

    public void setTotalBillToPay(Double totalBillToPay) {
        this.totalBillToPay= totalBillToPay;
    }
    private String fullName(){
        String fullName ;
        fullName = firstName + "" + lastName;
        return  fullName;
    }
     public  ArrayList <Bill> getBillsArray() {
     Collection<Bill> objBills = billHashMap.values();
     return new ArrayList<>(objBills);

    }

    public  Double getTotalBill(){
       double custTotalBill = 0.0;
       for(Bill b:billHashMap.values()){

           custTotalBill += b.totalBillAmount;
       }
       return custTotalBill;
    }




        public void addBill(Bill bill, String billId){
        billHashMap.put(billId,bill);
       this.totalBillToPay = this.totalBillToPay + bill.totalBillAmount;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void removeBill(Bill bill, String billId){
      billHashMap.remove(billId,bill);
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.customerId);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.fullName);
        dest.writeString(this.email);
        dest.writeMap(this.billHashMap);
        dest.writeValue(this.totalBillToPay);
    }


}
