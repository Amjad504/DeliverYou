package com.example.deliveryou;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class Customer_Small_Goods extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] Type={"International Passport","Gifts and flowers","Electronics and gadgets","Food and beverages","Clothing and accessories","Home goods and decorations","Sporting equipment and gear","Art and collectibles","Industrial parts and tools","Other"};

    EditText pickup_time;
    Spinner item_type;
    Button delivery_submit;
    int day, month, year, hour, minute;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_small_goods);
        getSupportActionBar().hide();

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(0xFFFFFFFF);
        window.setStatusBarColor(0xFFFFFFFF);


        delivery_submit = findViewById(R.id.confirm_deleviry);
        pickup_time = findViewById(R.id.pickup_time);
        pickup_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR_OF_DAY);
                minute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(Customer_Small_Goods.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                pickup_time.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });
        item_type = findViewById(R.id.item_type);
        item_type.setOnItemSelectedListener(this);
        CustomAdapter customAdapter = new CustomAdapter(Customer_Small_Goods.this.getApplicationContext(),Type);
        item_type.setAdapter(customAdapter);
        item_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Difficulty = Difficultyoptions[position];
//
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        delivery_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Customer_Small_Goods.this,Confirm_delivery.class);
                startActivity(i);

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}