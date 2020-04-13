package com.example.c0768706_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
     private TextView text_email;
     private TextView text_password;
     private Button btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_email = findViewById(R.id.text_email);
        text_password = findViewById(R.id.text_password);
        btn_submit = findViewById(R.id.btn_login);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = "admin@123";
                String Password ="s3cr3t";
                if(text_email.getText().toString().isEmpty()){
                    text_email.setError(" Field is not to be empty");
                    alertBox(LoginActivity.this,"Alert","Enter the Email");
                }else if(text_password.getText().toString().isEmpty()){
                    text_password.setError("Field is not to be empty");
                    alertBox(LoginActivity.this,"Alert","Enter the Password");

                }else if(text_email.getText().toString().equals(Email)&&(text_password.getText().toString().equals(Password))){
                    Toast.makeText(getApplicationContext(),"Log In Succesful",Toast.LENGTH_LONG).show();

                   Intent mIntent = new Intent(LoginActivity.this, CustomerListActivity.class);
                    startActivity(mIntent);
                }else{
                    alertBox(LoginActivity.this,"Invalid Value","Invalid Email or Password ");

                }

            }
        });
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
