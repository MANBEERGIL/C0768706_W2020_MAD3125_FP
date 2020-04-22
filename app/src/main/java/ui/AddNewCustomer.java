package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0768706_w2020_mad3125_fp.R;

import java.util.Calendar;

import models.Customers;
import models.Singleton;

public class AddNewCustomer extends AppCompatActivity {
    DatePickerDialog.OnDateSetListener mDateSetLstener;
    private TextView text_birth_date;
    private TextView text_age;
    private EditText text_custId;
    private EditText text_first_name;
    private EditText text_last_name;
    private  EditText text_email;
    private RadioGroup radioGroup;
    private RadioButton radio_male;
    private RadioButton radio_female;
    private RadioButton radio_others;
    private Button btn_save;
    Customers cust;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add New Customer");
        setContentView(R.layout.activity_add_new_customer);
        text_custId = findViewById(R.id.text_custid);
        text_birth_date = findViewById(R.id.text_birth_date);
        text_first_name = findViewById(R.id.text_first_name);
        text_last_name = findViewById(R.id.text_last_name);
        text_email = findViewById(R.id.text_email);
        radioGroup = findViewById(R.id.radioGroup);
        text_age = findViewById( R.id.text_age);
        radio_female = findViewById(R.id.radio_female);
        radio_male = findViewById(R.id.radio_male);
        radio_others = findViewById(R.id.radio_others);
        btn_save  = findViewById(R.id.btn_save);
        btn_save.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_custId.getText().toString().isEmpty()) {
                    text_custId.setError( "Enter the customer Id" );
                } else if (text_first_name.getText().toString().isEmpty()) {
                    text_first_name.setError( "Enter the first name" );
                } else if (text_last_name.getText().toString().isEmpty()) {
                    text_last_name.setError( "Enter the last name" );
                } else if (text_birth_date.getText().toString().isEmpty()) {
                    text_birth_date.setError( "Enter the birth date" );
                } else if (text_age.getText().toString().isEmpty()) {
                    text_age.setError( "Enter the age" );
                } else if (text_email.getText().toString().matches( "[A-Z0-9a-z.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}" )) {

                    Customers newCustomer = new Customers( text_custId.getText().toString(), text_first_name.getText().toString(), text_last_name.getText().toString(), text_email.getText().toString(), getGender(), text_birth_date.getText().toString() );
                    Singleton.getInstance().addCustomers( newCustomer.getCustomerId(), newCustomer );
                    Intent aIntent = new Intent( AddNewCustomer.this, CustomerListActivity.class );
                    Bundle bundle = new Bundle();
                    bundle.putParcelable( "newCustomer", cust );
                    startActivity( aIntent );
                }
            }
        } );
        text_birth_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calendar calender = Calendar.getInstance();
                int year = calender.get(Calendar.YEAR);
                int month = calender.get(Calendar.MONTH);
                int day = calender.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(AddNewCustomer.this,
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
                String date = "Birth Date : " + month + "/" + dayOfMonth + "/" + year;
                text_birth_date.setText(date);
                Calendar dob = Calendar.getInstance();
                Calendar today = Calendar.getInstance();
                dob.set(year, month, dayOfMonth);
                int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
                Integer ageInt = new Integer(age);
                String ageS = ageInt.toString();
                if (age > 0) {
                    text_age.setText( ageS );
                } else {
                    Toast.makeText(AddNewCustomer.this, "Incorrect birth date", Toast.LENGTH_LONG).show();
                }

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
                Intent gIntent = new Intent(AddNewCustomer.this,CustomerListActivity.class);
                startActivity(gIntent);
                return  true ;
            default:
                return super.onOptionsItemSelected(item);}
    }

    public  String getGender(){
      if(radio_male.isChecked()){
          return  "Male";
       }
      else if(radio_female.isChecked()){
          return "Female";
      }
      else if(radio_others.isChecked()){
          return "Others";
      }
      return  null;
    }

}