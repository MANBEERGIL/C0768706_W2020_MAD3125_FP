package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.c0768706_w2020_mad3125_fp.R;

public class AddNewInternetBillActivity extends AppCompatActivity {
    private EditText text_net_id;
    private EditText text_date;
    private  EditText text_provider_name;
    private EditText text_internet_used;
    private Button btn_internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_internet_bill);
        text_net_id = findViewById(R.id.text_net_id);
        text_date = findViewById(R.id.text_bill_date);
        text_provider_name = findViewById(R.id.text_provider_name);
        text_internet_used = findViewById(R.id.text_internet_used);
        btn_internet = findViewById(R.id.btn_mobile);
        btn_internet.setOnClickListener(new View.OnClickListener() {
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
                    Intent aIntent = new Intent(AddNewInternetBillActivity.this,ShowBillDetailsActivity.class);
                    startActivity(aIntent);
                }
            }
        });



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
                Intent aIntent = new Intent(AddNewInternetBillActivity.this,ShowBillDetailsActivity.class);
                startActivity(aIntent);
                break;}
        return super.onOptionsItemSelected(item);}
}
