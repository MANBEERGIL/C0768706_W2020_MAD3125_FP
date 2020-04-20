package models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Bill implements Parcelable {

    public enum billType{
        HYDRO,INTERNET,MOBILE
    }

    public Double totalBillAmount;
    private  String billId;
    private Date billDate;
    private billType billType;



    public Bill(String billId, Date billDate, billType billType) {
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
    protected Bill(Parcel in) {
        if (in.readByte() == 0) {
            totalBillAmount = null;
        } else {
            totalBillAmount = in.readDouble();
        }
       this. billId = in.readString();
       this. billType = (Bill.billType) in.readValue(billType.class.getClassLoader());
    }

    public static final Creator<Bill> CREATOR = new Creator<Bill>() {
        @Override
        public Bill createFromParcel(Parcel in) {
            return new Bill(in);
        }

        @Override
        public Bill[] newArray(int size) {
            return new Bill[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (totalBillAmount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(totalBillAmount);
        }
        dest.writeString(billId);
        dest.writeString(String.valueOf(billType));
    }


  public Double calculateBill(){
        double intialAmount = 0.0;
        return intialAmount;
   }


}
