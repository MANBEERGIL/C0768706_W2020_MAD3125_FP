package ui;

public class Customer {

    private  String customerName;


    public Customer(String Name ) {
        customerName = Name;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
