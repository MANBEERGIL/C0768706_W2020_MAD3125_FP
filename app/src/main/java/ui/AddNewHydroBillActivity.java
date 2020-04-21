package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
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

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import models.Bill;
import models.Customers;
import models.Hydro;
import models.Singleton;

public class AddNewHydroBillActivity extends AppCompatActivity {
    public static Customers dataobj;
    private EditText text_h_id;
    private EditText bill_date;
    private EditText text_agency;
    private EditText text_units;
    private Button btn_hydro;
    DatePickerDialog.OnDateSetListener mDateSetLstener;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
    private static  int selection = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_hydro_bill);
        getSupportActionBar().setTitle("Add Hydro Bill");
        text_h_id = findViewById(R.id.text_custid);
        bill_date = findViewById(R.id.bill_date);
        text_agency = findViewById(R.id.text_agency);
        text_units = findViewById(R.id.text_units);
        btn_hydro = findViewById(R.id.btn_hydro);
      // dataobj = Singleton.getInstance().getAllCustomers().get(getIntent().getIntExtra("customers",selection));
        btn_hydro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_h_id.getText().toString().isEmpty()) {
                    text_h_id.setError("Enter the bill Id");
                } else if (bill_date.getText().toString().isEmpty()) {
                    bill_date.setError("Enter the bill date");
                } else if (text_agency.getText().toString().isEmpty()) {
                    text_agency.setError("Enter the name of agency");
                } else if (text_units.getText().toString().isEmpty()) {
                    text_units.setError("Enter the Units consumed");
                } else {
                    Hydro hydro1 = new Hydro(text_h_id.getText().toString(), bill_date.getText().toString(), Bill.billType.HYDRO,text_agency.getText().toString(),Integer.parseInt(text_units.getText().toString()) );
                    dataobj.addBill(hydro1,hydro1.getBillId());
                    Intent bIntent = new Intent(AddNewHydroBillActivity.this, ShowBillDetailsActivity.class);
                    startActivity(bIntent);
                }

            }
        });

        bill_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calender = Calendar.getInstance();
                int year = calender.get(Calendar.YEAR);
                int month = calender.get(Calendar.MONTH);
                int day = calender.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(AddNewHydroBillActivity.this,
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
                bill_date.setText(date);

            }
        };

    }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu_back, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case R.id.back:
                    Intent cIntent = new Intent(AddNewHydroBillActivity.this, ShowBillDetailsActivity.class);
                    startActivity(cIntent);
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

}