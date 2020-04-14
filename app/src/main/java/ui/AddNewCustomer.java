package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0768706_w2020_mad3125_fp.R;

import java.util.Calendar;

public class AddNewCustomer extends AppCompatActivity {
    Spinner spinner_bill_type;
    String status;
    DatePickerDialog.OnDateSetListener mDateSetLstener;
    private TextView text_birth_date;
    private TextView text_age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        text_birth_date = findViewById(R.id.text_birth_date);
        text_age = findViewById(R.id.text_age);
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
                    text_age.setText(ageS);
                } else {
                    Toast.makeText(AddNewCustomer.this, "Incorrect birth date", Toast.LENGTH_LONG).show();
                }

            }
        };
    }
}