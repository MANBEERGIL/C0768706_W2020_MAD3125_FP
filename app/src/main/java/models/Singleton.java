package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Singleton {
    private static  Singleton dataobj = new Singleton();
     public static Singleton getInstance(){
         return  dataobj;
     }
     private Singleton(){}
       private  HashMap<String,Customers> customersHashMap = new HashMap<>();

    public HashMap<String, Customers> getCustomersHashMap() {
        return this.customersHashMap;
    }
    public  ArrayList<Customers> getAllCustomers(){
        Collection<Customers>collection = customersHashMap.values();
        ArrayList<Customers>customersArrayList =new ArrayList<Customers>(collection);
       return customersArrayList;
    }
    public void addCustomers(String customerId, Customers customers){
      this.customersHashMap.put(customers.getCustomerId(),customers);
    }
    public  void getData() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
//        Customers co = new Customers("c01","Manbeer","Kaur","manbeergill545@gmail.com","Female","20/04/1997");
//        Customers ca = new Customers("c02","Manpreet","Kaur","manpreetsran545@gmail.com","Female","12/12/1997");
        Customers c1 = new Customers("c03","Harminder","Kaur","harminder545@gmail.com","Female","24/06/1998");
        Customers c2 = new Customers("c04","Rupinder","Kaur","rupindergill545@gmail.com","Female","23/12/1994");
        Customers c3 = new Customers("c01","Manbeer","Kaur","manbeergill545@gmail.com","Female","20/04/1997");
        Customers c4 = new Customers("c02","Manpreet","Kaur","manpreetsran545@gmail.com","Female","12/12/1997");



        customersHashMap.put(c1.getCustomerId(),c1);
        customersHashMap.put(c2.getCustomerId(),c2);
        customersHashMap.put(c3.getCustomerId(),c3);
        customersHashMap.put(c4.getCustomerId(),c4);

        Mobile m1 = new Mobile("m01",dateFormat.parse("23/04/2020"),Bill.billType.MOBILE,"Samsung","4GB+talktime","6476854431",4,100);
        Mobile m2 = new Mobile("m02",dateFormat.parse("24/04/2020"),Bill.billType.MOBILE,"Oppo","8GB+ Unlinited talktime","6476854451",8,4200);
        Mobile m3 = new Mobile("m03",dateFormat.parse("25/04/2020"),Bill.billType.MOBILE,"Apple","4GB+talktime","6476854461",4,50);



        Internet i1 = new Internet("i01",dateFormat.parse("23/04/2020"),Bill.billType.INTERNET,"Fido",  4);
        Internet i2 = new Internet("i02",dateFormat.parse("24/04/2020"),Bill.billType.INTERNET,"Rogers",  6);
        Internet i3 = new Internet("i03",dateFormat.parse("25/04/2020"),Bill.billType.INTERNET,"Freedom",  5);


        Hydro h1 = new Hydro("h01",dateFormat.parse("23/04/2020"),Bill.billType.HYDRO,"Toronto Hydro",50);
        Hydro h2 = new Hydro("h02",dateFormat.parse("24/04/2020"),Bill.billType.HYDRO,"Toronto Hydro",65);
        Hydro h3 = new Hydro("h03",dateFormat.parse("25/04/2020"),Bill.billType.HYDRO,"Toronto Hydro",45);



        c1.addBill(i1,i1.getBillId());
        c1.addBill(h1,h1.getBillId());
        c1.addBill(m1,m1.getBillId());

        c2.addBill(m2,m2.getBillId());
        c2.addBill(i1,i1.getBillId());
        c2.addBill(h3,h3.getBillId());

        c3.addBill(h3,h3.getBillId());
        c3.addBill(i3,i3.getBillId());

        c4.addBill(i2,i2.getBillId());
        c4.addBill(h2,h2.getBillId());
    }


}
