package com.example.deliveryou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class Phone_verification extends AppCompatActivity {

    Button verify;
    int ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification);
        getSupportActionBar().hide();


        ID = getIntent().getIntExtra("ID",0);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(0xFFFFFFFF);
        window.setStatusBarColor(0xFFFFFFFF);



        verify = findViewById(R.id.verify_code);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ID == 2)
                {
                    Intent i = new Intent(Phone_verification.this,Signup_Driver2.class);
                    startActivity(i);
                }
                else if (ID == 1)
                {
                    Intent i = new Intent(Phone_verification.this,Customer_Delivery_Option.class);
                    startActivity(i);
                }


            }
        });
    }
}