package ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.c0768706_w2020_mad3125_fp.R;

import java.sql.Date;
import java.util.Calendar;

import models.Bill;
import models.Customers;
import models.Internet;

public class AddNewInternetBillActivity extends AppCompatActivity {
    public static Customers custobj;
    private EditText text_net_id;
    private EditText text_date;
    private  EditText text_provider_name;
    private EditText text_internet_used;
    private Button btn_internet;
    DatePickerDialog.OnDateSetListener mDateSetLstener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_internet_bill);
        getSupportActionBar().setTitle("Add Internet Bill");
        text_net_id = findViewById(R.id.text_net_id);
        text_date = findViewById(R.id.text_bill_date);
        text_provider_name = findViewById(R.id.text_provider_name);
        text_internet_used = findViewById(R.id.text_internet_used);
        btn_internet = findViewById(R.id.btn_internet);

        btn_internet.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(text_net_id.getText().toString().isEmpty()){
                    text_net_id.setError("Enter the bill Id");
                }else if(text_date.getText().toString().isEmpty()){
                    text_date.setError("Enter the bill date");
                }else if(text_provider_name.getText().toString().isEmpty()){
                    text_provider_name.setError("Enter the name of agency");
                }else if(text_internet_used.getText().toString().isEmpty()){
                    text_internet_used.setError("Enter the Units consumed");
                }else{
                    Internet internet = new Internet(text_net_id.getText().toString(), text_date.getText().toString(), Bill.billType.INTERNET,text_provider_name.getText().toString(),Integer.parseInt(text_internet_used.getText().toString()));
                    custobj.addBill(internet,internet.getBillId());
                    Intent dIntent = new Intent(AddNewInternetBillActivity.this,ShowBillDetailsActivity.class);
                    startActivity(dIntent);
                }
            }
        });
        text_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calender = Calendar.getInstance();
                int year = calender.get(Calendar.YEAR);
                int month = calender.get(Calendar.MONTH);
                int day = calender.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(AddNewInternetBillActivity.this,
                        R.style.Theme_AppCompat_Light_Dialog_MinWidth, mDateSetLstener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });
        mDateSetLstener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d("PersonalInformation", "onDateSet:mm/dd/yyyy:" + month + "/" + dayOfMonth + "/" + year);
                String date = month + "/" + dayOfMonth + "/" + year;
                text_date.setText(date);
            }
        };

    }
    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_back,menu);
        return  true;
    }
    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.back:
                Intent eIntent = new Intent(AddNewInternetBillActivity.this, ShowBillDetailsActivity.class);
                startActivity(eIntent);
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }
}
