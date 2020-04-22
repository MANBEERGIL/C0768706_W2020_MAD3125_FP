package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.c0768706_w2020_mad3125_fp.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;

import adapter.BillAdapter;
import models.Bill;
import models.Customers;
import models.Singleton;

public class  ShowBillDetailsActivity extends AppCompatActivity {
     private  Customers cust;
     private TextView text_custid;
     private TextView text_name;
     private TextView text_email;
     private TextView text_total;
     private TextView text_gender;
     private TextView text_dob;
     private TextView text_label;
     private ArrayList<Bill>bill;
     private   int selection = 0;
     private RecyclerView rvBill;
     private  ArrayList<Bill>arrayList;
     private  BillAdapter billAdapter;
     private Customers cus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);
        getSupportActionBar().setTitle("Bill Details");
        //Intent pIntent = getIntent();
       // c =pIntent.getParcelableExtra("customer");

        cust = Singleton.getInstance().getAllCustomers().get(getIntent().getIntExtra("customer selected",selection));
        text_custid = findViewById(R.id.text_custid);
        text_name = findViewById(R.id.text_name);
        text_email = findViewById(R.id.text_email);
        text_total = findViewById(R.id.text_total);
        text_dob = findViewById(R.id.text_dob);
        text_gender = findViewById(R.id.text_phone);
        text_label = findViewById(R.id.text_label);
        text_custid.setText("Customer ID:"+cust.getCustomerId());
          text_name.setText("Customer Name:"+cust.getFullName());
          text_email.setText("Email ID:"+cust.getEmail());
          text_dob.setText("Date of Birth:"+cust.getBirthDate());
          text_gender.setText("Gender:"+cust.getGender());
         // NumberFormat format = NumberFormat.getCurrencyInstance();
          // format.setCurrency(Currency.getInstance("CAD"));
           text_total.setText("Total Bill: $"+cust.getTotalBillToPay());
        bill = cust.getBillsArray();
        rvBill = findViewById(R.id.rvBill);
        billAdapter = new BillAdapter(this.bill);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvBill.setLayoutManager(layoutManager1);
        rvBill.setAdapter(billAdapter);
//        Intent bIntent =  getIntent();
//        cust = bIntent.getParcelableExtra("customer");
}
    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bill,menu);
        menuInflater.inflate(R.menu.menu_back,menu);
        return  true;
    }
    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.add_hydro:
                AddNewHydroBillActivity.custobj = cust;
                Intent lIntent = new Intent(ShowBillDetailsActivity.this, AddNewHydroBillActivity.class);
                lIntent.putExtra("customers", cust);
                startActivity(lIntent);
                return true;
            case R.id.add_internet:
                AddNewInternetBillActivity.custobj = cust;
                Intent mIntent = new Intent(ShowBillDetailsActivity.this, AddNewInternetBillActivity.class);
                startActivity(mIntent);
                return true;
            case R.id.add_mobile:
                AddNewMobileBillActivity.custobj = cust;
                Intent nIntent = new Intent(ShowBillDetailsActivity.this, AddNewMobileBillActivity.class);
                startActivity(nIntent);
                return true;
            case R.id.back:
                Intent gIntent = new Intent(ShowBillDetailsActivity.this,CustomerListActivity.class);
                startActivity(gIntent);
                return  true ;

            default:
            return super.onOptionsItemSelected(item);
        }
    }






}




