package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.c0768706_w2020_mad3125_fp.R;

import java.text.ParseException;
import java.util.ArrayList;

import adapter.CustomerAdapter;
import models.Customers;
import models.Singleton;

public class CustomerListActivity extends AppCompatActivity {
    private RecyclerView rvCustomerList;
    private ArrayList<Customers> rvcustomers;
    private CustomerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        rvCustomerList=findViewById(R.id.rvCustomerList);
        Singleton singleton = Singleton.getInstance();
        try {
            singleton.getData();
        }catch (ParseException e){
            e.printStackTrace();
        }
        rvcustomers = new ArrayList<>(Singleton.getInstance().getAllCustomers());
        customerAdapter = new CustomerAdapter(rvcustomers);
        RecyclerView.LayoutManager m =new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
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
                Intent hIntent = new Intent(CustomerListActivity.this,LoginActivity.class);
                startActivity(hIntent);
                return  true;
            case R.id.add_customer:
                Intent iIntent = new Intent(CustomerListActivity.this,AddNewCustomer.class);
                startActivity(iIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

   }
}
