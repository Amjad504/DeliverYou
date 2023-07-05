package com.example.deliveryou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Carpool_request_list extends AppCompatActivity {

    RecyclerView carpool_rv;
    Carpool_Adapter Carpool_Adapter;
    List<Carpool_info> carpool_list;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpool_request_list);
        getSupportActionBar().hide();

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(0xFFFFFFFF);
        window.setStatusBarColor(0xFFFFFFFF);

        carpool_rv = findViewById(R.id.carpool_request);

        carpool_list = new ArrayList<>();

        Carpool_Adapter = new Carpool_Adapter(carpool_list, this);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        carpool_rv.setLayoutManager(lm);
        carpool_rv.setAdapter(Carpool_Adapter);


        carpool_list.add(new Carpool_info("123","Amjad Arshad",null,"Building 543, F-11","Building 302,G-11","4:00","4:30","30",4));
        carpool_list.add(new Carpool_info("123","Amjad Arshad",null,"Building 543, F-11","Building 302,G-11","4:00","4:30","30",4));
        carpool_list.add(new Carpool_info("123","Amjad Arshad",null,"Building 543, F-11","Building 302,G-11","4:00","4:30","30",4));
        carpool_list.add(new Carpool_info("123","Amjad Arshad",null,"Building 543, F-11","Building 302,G-11","4:00","4:30","30",4));
        carpool_list.add(new Carpool_info("123","Amjad Arshad",null,"Building 543, F-11","Building 302,G-11","4:00","4:30","30",4));
        carpool_list.add(new Carpool_info("123","Amjad Arshad",null,"Building 543, F-11","Building 302,G-11","4:00","4:30","30",4));

        Carpool_Adapter.notifyDataSetChanged();



    }
}