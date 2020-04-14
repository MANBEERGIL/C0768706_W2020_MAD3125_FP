package models;

public class Hydro {
    private  String agencyName;
    private String unitConsumed;

    public Hydro(String agencyName, String unitConsumed) {
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
