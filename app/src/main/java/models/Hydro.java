package models;

import java.util.Date;

public class Hydro extends  Bill{
    private  String agencyName;
    private int unitConsumed;

    public Hydro(String billId,  Date billDate,billType billType, String agencyName, int unitConsumed) {
        super(billId,billDate,billType);
        this.agencyName = agencyName;
        this.unitConsumed = unitConsumed;
        this.totalBillAmount = calculateBill();
    }

    public Double calculateBill() {
        double billAmount = 0.0;
        if(unitConsumed<10){
            billAmount = 2*unitConsumed;
        }
        else{
            billAmount = 2.5*unitConsumed;
        }

        return billAmount;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public int getUnitConsumed() {
        return unitConsumed;
    }

    public void setUnitConsumed(int unitConsumed) {
        this.unitConsumed = unitConsumed;
    }


}

