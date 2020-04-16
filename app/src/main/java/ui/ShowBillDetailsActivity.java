package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.c0768706_w2020_mad3125_fp.R;

public class  ShowBillDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);

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
                Intent aIntent = new Intent(ShowBillDetailsActivity.this,AddNewHydroBillActivity.class);
                startActivity(aIntent);
                break;
            case R.id.add_internet:
                Intent bIntent = new Intent(ShowBillDetailsActivity.this,AddNewInternetBillActivity.class);
                startActivity(bIntent);
                break;
            case R.id.add_mobile:
                Intent cIntent = new Intent(ShowBillDetailsActivity.this,AddNewMobileBillActivity.class);
                startActivity(cIntent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}




