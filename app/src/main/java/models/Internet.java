package models;

import java.util.Date;

public class Internet extends Bill{
    private  String providerName;
    private  int internetGbUsed;

    public Internet(String billId, String billDate,billType billType,String providerName,int internetGbUsed) {
        super(billId,billDate, Bill.billType.INTERNET);
        this.providerName = providerName;
        this.internetGbUsed = internetGbUsed;
        this.totalBillAmount = calculateBill();
    }

    public Double calculateBill() {
        this.totalBillAmount = (double)internetGbUsed*5;
        return this.totalBillAmount;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public int getInternetGbUsed() {
        return internetGbUsed;
    }

    public void setInternetGbUsed(int internetUsed) {
        this.internetGbUsed = internetGbUsed;
    }
}
