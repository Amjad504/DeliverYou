package com.example.deliveryou;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Driver_Options extends AppCompatActivity {
    RadioButton carpoolradio,deliveryradio;
    TextView continue_btn;

    ImageView profile;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_options);
        getSupportActionBar().hide();

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(0xFFFFFFFF);
        window.setStatusBarColor(0xFFFFFFFF);

        continue_btn = findViewById(R.id.contnue_btn_driver);
        carpoolradio = findViewById(R.id.Carpool_driver);
        deliveryradio = findViewById(R.id.Small_Goods_driver);
        profile = findViewById(R.id.profile_pic_driver);

        carpoolradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!carpoolradio.isSelected()) {
                    carpoolradio.setChecked(true);
                    carpoolradio.setSelected(true);
                    deliveryradio.setChecked(false);
                    deliveryradio.setSelected(false);
                } else {
                    carpoolradio.setChecked(false);
                    carpoolradio.setSelected(false);
                }
            }
        });
        deliveryradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!deliveryradio.isSelected()) {
                    carpoolradio.setChecked(false);
                    carpoolradio.setSelected(false);
                    deliveryradio.setChecked(true);
                    deliveryradio.setSelected(true);
                } else {
                    deliveryradio.setChecked(false);
                    deliveryradio.setSelected(false);
                }
            }
        });
        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carpoolradio.isSelected())
                {
                    Intent i = new Intent(Driver_Options.this,Carpool_request_list.class);
                    startActivity(i);
                }
                else if (deliveryradio.isSelected())
                {
                    Intent i = new Intent(Driver_Options.this,Driver_Goods_Delivery.class);
                    startActivity(i);
                }
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Driver_Options.this,Profile.class);
                startActivity(i);
            }
        });
    }
}