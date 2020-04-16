package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.c0768706_w2020_mad3125_fp.R;

import java.util.ArrayList;

import adapter.CustomerAdapter;

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
   @Override
   public  boolean onCreateOptionsMenu(Menu menu){
       MenuInflater menuInflater = getMenuInflater();
       menuInflater.inflate(R.menu.menu_item,menu);
        return  true;
   }
   @Override
   public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.log_out:
                Intent aIntent = new Intent(CustomerListActivity.this,LoginActivity.class);
                startActivity(aIntent);
                break;
            case R.id.add_customer:
                Intent bIntent = new Intent(CustomerListActivity.this,AddNewCustomer.class);
                startActivity(bIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
   }
    void customersList(){
        customers=new ArrayList<>();

//     customers.add(new Customer("  Geetanjali Gupta"));
       customers.add(new Customer("  Manbeer kaur"));
     customers.add(new Customer("  Komal Subhra"));
       customers.add(new Customer("  Manpreet Kaur"));
        customers.add(new Customer("  Geetanjali Gupta"));
        customers.add(new Customer("  Manbeer kaur"));
    }



}
