package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0768706_w2020_mad3125_fp.R;

import java.util.prefs.Preferences;

public class LoginActivity extends AppCompatActivity {
     private TextView text_email;
     private TextView text_password;
     private Button btn_submit;
     private Switch remember_me;

    private    SharedPreferences preferences ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_email = findViewById(R.id.text_email);
        text_password = findViewById(R.id.text_password);
        btn_submit = findViewById(R.id.btn_login);
        remember_me = findViewById(R.id.remember_me);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = "manbeergill545@gmail.com";
                String Password = "s3cr3t";
                if (text_email.getText().toString().isEmpty()) {
                    text_email.setError(" Field is not to be empty");
                    alertBox(LoginActivity.this, "Alert", "Enter the Email");
                } else if (text_password.getText().toString().isEmpty()) {
                    text_password.setError("Field is not to be empty");
                    alertBox(LoginActivity.this, "Alert", "Enter the Password");

                } else if (text_email.getText().toString().equals(Email) && (text_password.getText().toString().equals(Password))) {
                    Toast.makeText(getApplicationContext(), "Log In Succesful", Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor editor = null;
                    if (remember_me.isChecked()) {
                        final SharedPreferences preferences = getSharedPreferences("Switch", MODE_PRIVATE);
                        editor = preferences.edit();
                        editor.putString("UserName", text_email.getText().toString());
                        editor.putString("Password", text_password.getText().toString());
                        editor.apply();

                        Intent mIntent = new Intent(LoginActivity.this, CustomerListActivity.class);
                        startActivity(mIntent);
                    } else {
                        editor.clear().apply();
                        Intent mIntent = new Intent(LoginActivity.this, CustomerListActivity.class);
                        startActivity(mIntent);
                    }
                } else {
                    alertBox(LoginActivity.this, "Invalid Value", "Invalid Email or Password ");

                }
            }

            });

      //  final SharedPreferences finalPreferences = preferences;

    }
    private void alertBox(Context context, String title,String message){
       android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(context);
       alertDialog.setTitle(title);
       alertDialog.setMessage(message);
       alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
           }
       });
       alertDialog.show();
    }
}
