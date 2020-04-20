package ui;

import androidx.appcompat.app.AppCompatActivity;

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
     private int selection = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);
        cust = Singleton.getInstance().getAllCustomers().get(getIntent().getIntExtra("customer",selection));
          text_custid.setText(cust.getCustomerId());
          text_name.setText(cust.getFullName());
          text_email.setText(cust.getEmail());
           bill= cust.getBills();
        NumberFormat format = NumberFormat.getCurrencyInstance();
           format.setCurrency(Currency.getInstance("CAD"));
           text_total.setText(format.format(cust.getTotalBillToPay()));
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
        switch (item.getItemId()){
            case R.id.add_hydro:
                AddNewHydroBillActivity.dataobj = cust;
                Intent lIntent = new Intent(ShowBillDetailsActivity.this,AddNewHydroBillActivity.class);
                lIntent.putExtra("customers",cust);
                startActivity(lIntent);
                return true;
            case R.id.add_internet:
                AddNewInternetBillActivity .dataobj = cust;
                Intent mIntent = new Intent(ShowBillDetailsActivity.this,AddNewInternetBillActivity.class);
                startActivity(mIntent);
                return  true;
            case R.id.add_mobile:
                AddNewMobileBillActivity.dataobj = cust;
                Intent nIntent = new Intent(ShowBillDetailsActivity.this,AddNewMobileBillActivity.class);
                startActivity(nIntent);
                return  true;

        }
        return super.onOptionsItemSelected(item);
    }
}




