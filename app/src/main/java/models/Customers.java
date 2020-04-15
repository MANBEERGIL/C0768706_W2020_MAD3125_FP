package models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Customers implements Parcelable {
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

    protected Customers(Parcel in) {
        customerId = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        fullName = in.readString();
        email = in.readString();
        if (in.readByte() == 0) {
            totalBillToPAY = null;
        } else {
            totalBillToPAY = in.readDouble();
        }
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerId);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(fullName);
        dest.writeString(email);
        if (totalBillToPAY == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(totalBillToPAY);
        }
    }
}
