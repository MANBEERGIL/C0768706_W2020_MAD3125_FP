package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.c0768706_w2020_mad3125_fp.R;

import java.sql.Date;
import java.util.Calendar;

import models.Bill;
import models.Customers;
import models.Mobile;
import models.Singleton;


public  class AddNewMobileBillActivity extends AppCompatActivity {

    public static Customers custobj;
    private EditText text_mob_id;
        private TextView text_bill_date;
        private EditText text_manufacturer;
        private  EditText text_planName;
        private  EditText text_mobile_no;
        private EditText text_net_used;
        private  EditText text_minute;
        private Button btn_mobile;
        private int selection = 1;
    DatePickerDialog.OnDateSetListener mDateSetLstener;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_new_mobile_bill);
            getSupportActionBar().setTitle("Add Mobile Bill");
           text_mob_id = findViewById(R.id.text_mob_id);
          text_manufacturer = findViewById(R.id.text_manufacturer);
          text_planName = findViewById(R.id.text_planName);
          btn_mobile = findViewById(R.id.btn_mobile);
          text_bill_date = findViewById(R.id.text_bill_date);
          text_mobile_no = findViewById(R.id.text_mobile_no);
          text_net_used = findViewById(R.id.text_net_used);
          text_minute = findViewById(R.id.text_minute);
            custobj = Singleton.getInstance().getAllCustomers().get(getIntent().getIntExtra("customer selected",selection));
          btn_mobile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(text_mob_id.getText().toString().isEmpty()){
                        text_mob_id.setError("Enter the bill Id");
            }else if(text_bill_date.getText().toString().isEmpty()){
               text_bill_date.setError("Enter the bill date");
            }else if(text_manufacturer.getText().toString().isEmpty()){
                text_manufacturer.setError("Enter the name of agency");
            }else if(text_planName.getText().toString().isEmpty()){
                text_planName.setError("Enter the Units consumed");
            }else if(text_mobile_no.getText().toString().isEmpty()){
                text_mobile_no.setError("Enter mobile number");
            }else if(text_net_used.getText().toString().isEmpty()){
                text_net_used.setError("Enter GB used");
            }else if(text_minute.getText().toString().isEmpty()){
                text_minute.setError("Enter the minute used");
            }else if(text_mobile_no.getText().toString().matches("[0-9]{10}")){
                Mobile mobile = new Mobile(text_mob_id.getText().toString(), text_bill_date.getText().toString(), Bill.billType.MOBILE,text_manufacturer.getText().toString(),text_planName.getText().toString(),text_mobile_no.getText().toString(),Integer.parseInt(text_net_used.getText().toString()),Integer.parseInt(text_minute.getText().toString()));
                  custobj.addBill(mobile,mobile.getBillId());
                Intent fIntent = new Intent(AddNewMobileBillActivity.this,ShowBillDetailsActivity.class);
                startActivity(fIntent);
            }
                    else{
                        alertBox(AddNewMobileBillActivity.this, "Invalid Value", "Invalid Mobile Number");;
                    }
                }
          });
           text_bill_date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar calender = Calendar.getInstance();
                    int year = calender.get(Calendar.YEAR);
                    int month = calender.get(Calendar.MONTH);
                    int day = calender.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog dialog = new DatePickerDialog(AddNewMobileBillActivity.this,
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
                    text_bill_date.setText(date);

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
            switch (item.getItemId()){
                case R.id.back:
                    Intent gIntent = new Intent(AddNewMobileBillActivity.this,ShowBillDetailsActivity.class);
                    startActivity(gIntent);
                    return  true ;
                default:
                    return super.onOptionsItemSelected(item);}
            }
    private void alertBox(Context context, String title, String message) {
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder( context );
        alertDialog.setTitle( title );
        alertDialog.setMessage( message );
        alertDialog.setPositiveButton( "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        } );
        alertDialog.show();
    }

    }

