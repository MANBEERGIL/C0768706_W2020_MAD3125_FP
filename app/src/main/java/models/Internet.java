package models;

public class Internet {
    private  String providerName;
    private  String internetGbUsed;

    public Internet(String providerName, String internetGbUsed) {
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
