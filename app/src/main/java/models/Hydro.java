package models;

import java.util.Date;

public class Hydro extends  Bill{
    private  String agencyName;
    private String unitConsumed;

    public Hydro(String billId, String billType, Date billDate, String agencyName, String unitConsumed) {
        super(billId,billDate,billType);
        this.agencyName = agencyName;
        this.unitConsumed = unitConsumed;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getUnitConsumed() {
        return unitConsumed;
    }

    public void setUnitConsumed(String unitConsumed) {
        this.unitConsumed = unitConsumed;
    }
}
