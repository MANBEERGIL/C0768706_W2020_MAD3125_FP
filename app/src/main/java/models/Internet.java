package models;

import java.util.Date;

public class Internet extends Bill{
    private  String providerName;
    private  String internetGbUsed;

    public Internet(String billId, Date billDate,String billType,String providerName, String internetGbUsed) {
        super(billId,billDate,billType);
        this.providerName = providerName;
        this.internetGbUsed = internetGbUsed;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getInternetGbUsed() {
        return internetGbUsed;
    }

    public void setInternetGbUsed(String internetGbUsed) {
        this.internetGbUsed = internetGbUsed;
    }
}
