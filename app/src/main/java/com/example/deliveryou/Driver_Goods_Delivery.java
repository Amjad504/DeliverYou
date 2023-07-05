package com.example.deliveryou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class Driver_Goods_Delivery extends AppCompatActivity {

    RecyclerView delivery_rv;
    Delivery_Adapter delivery_adapter;
    List<Delivery_Info> delivery_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_goods_delivery);
        getSupportActionBar().hide();

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(0xFFFFFFFF);
        window.setStatusBarColor(0xFFFFFFFF);


        delivery_rv = findViewById(R.id.delivery_request);

        delivery_list = new ArrayList<>();

        delivery_adapter = new Delivery_Adapter(delivery_list,this);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        delivery_rv.setLayoutManager(lm);
        delivery_rv.setAdapter(delivery_adapter);


        delivery_list.add(new Delivery_Info("123","Amjad Arshad","Building 543, F-11","Building 302,G-11","4:00","4:30","30","10","10","10","10",null,4));
        delivery_list.add(new Delivery_Info("123","Amjad Arshad","Building 543, F-11","Building 302,G-11","4:00","4:30","30","10","10","10","10",null,4));
        delivery_list.add(new Delivery_Info("123","Amjad Arshad","Building 543, F-11","Building 302,G-11","4:00","4:30","30","10","10","10","10",null,4));
        delivery_list.add(new Delivery_Info("123","Amjad Arshad","Building 543, F-11","Building 302,G-11","4:00","4:30","30","10","10","10","10",null,4));
        delivery_list.add(new Delivery_Info("123","Amjad Arshad","Building 543, F-11","Building 302,G-11","4:00","4:30","30","10","10","10","10",null,4));

        delivery_adapter.notifyDataSetChanged();

    }
}