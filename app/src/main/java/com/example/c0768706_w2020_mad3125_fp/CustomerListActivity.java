package com.example.c0768706_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CustomerListActivity extends AppCompatActivity {
    private RecyclerView rvCustomerList;
    private ArrayList<Customer> customers;
    private CustomerAdapter customerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        rvCustomerList=findViewById(R.id.rvCustomerList);
        customersList();
        customerAdapter=new CustomerAdapter(customers);
        RecyclerView.LayoutManager m=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvCustomerList.setLayoutManager(m);
        rvCustomerList.setAdapter(customerAdapter);
    }
    void customersList(){
        customers=new ArrayList<>();
       customers.add(new Customer("  Manbeer kaur"));
//       customers.add(new Customer("  Geetanjali Gupta"));
//       customers.add(new Customer("  Komal Subhra"));
//       customers.add(new Customer("  Manpreet Kaur"));


    }
}
