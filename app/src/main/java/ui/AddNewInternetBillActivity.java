package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.c0768706_w2020_mad3125_fp.R;

public class AddNewInternetBillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_internet_bill);
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
