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
     private EditText text_custid;
     private EditText text_name;
     private EditText text_email;
     private EditText text_total;
     private ArrayList<Bill>bill;
     private  static int selection = 0;
     private RecyclerView rvBill;
     private  ArrayList<Bill>arrayList;
     private  BillAdapter billAdapter;
     Customers c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);
        getSupportActionBar().setTitle("Bill Details");
        Intent pIntent = getIntent();
        c =pIntent.getParcelableExtra("customer");

        cust = Singleton.getInstance().getAllCustomers().get(getIntent().getIntExtra("customer selected",selection));
        text_custid = findViewById(R.id.text_custid);
        text_name = findViewById(R.id.text_name);
        text_email = findViewById(R.id.text_email);
        text_total = findViewById(R.id.text_total);
        text_total.setTransformationMethod(null);
        text_custid.setText("Customer ID:"+cust.getCustomerId());
          text_name.setText("Customer Name:"+cust.getFirstName());
          text_email.setText("Email Address:"+cust.getEmail());
          NumberFormat format = NumberFormat.getCurrencyInstance();
           format.setCurrency(Currency.getInstance("CAD"));
           text_total.setText(format.format(cust.getTotalBillToPay()));
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
        return  true;
    }
    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.add_hydro:
                AddNewHydroBillActivity.dataobj = cust;
                Intent lIntent = new Intent(ShowBillDetailsActivity.this, AddNewHydroBillActivity.class);
                lIntent.putExtra("customers", cust);
                startActivity(lIntent);
                return true;
            case R.id.add_internet:
                AddNewInternetBillActivity.dataobj = cust;
                Intent mIntent = new Intent(ShowBillDetailsActivity.this, AddNewInternetBillActivity.class);
                startActivity(mIntent);
                return true;
            case R.id.add_mobile:
                AddNewMobileBillActivity.dataobj = cust;
                Intent nIntent = new Intent(ShowBillDetailsActivity.this, AddNewMobileBillActivity.class);
                startActivity(nIntent);
                return true;

            default:
            return super.onOptionsItemSelected(item);
        }
    }
}




