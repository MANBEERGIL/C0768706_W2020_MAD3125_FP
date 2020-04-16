package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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

import com.example.c0768706_w2020_mad3125_fp.R;

import java.util.Calendar;


public  class AddNewMobileBillActivity extends AppCompatActivity {

        private EditText text_mob_id;
        private EditText text_bill_date;
        private EditText text_manufacturer;
        private  EditText text_planName;
        private  EditText text_mobile_no;
        private EditText text_net_used;
        private  EditText text_minute;
        private Button btn_mobile;
    DatePickerDialog.OnDateSetListener mDateSetLstener;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_new_mobile_bill);
           text_mob_id = findViewById(R.id.text_mob_id);
          text_manufacturer = findViewById(R.id.text_manufacturer);
          text_planName = findViewById(R.id.text_planName);
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
            }else{
                Intent aIntent = new Intent(AddNewMobileBillActivity.this,ShowBillDetailsActivity.class);
                startActivity(aIntent);
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
                    Intent aIntent = new Intent(AddNewMobileBillActivity.this,ShowBillDetailsActivity.class);
                    startActivity(aIntent);
                    break;}
            return super.onOptionsItemSelected(item);}
    }

