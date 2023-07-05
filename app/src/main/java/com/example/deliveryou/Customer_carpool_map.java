package com.example.deliveryou;

import static android.content.ContentValues.TAG;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.deliveryou.databinding.ActivityCustomerCarpoolMapBinding;

public class Customer_carpool_map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityCustomerCarpoolMapBinding binding;
    Button settime;
    Calendar date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCustomerCarpoolMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        settime = findViewById(R.id.select_time);
        settime.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Customer_carpool_map.this,Customer_date_time.class);
                startActivity(i);

//                showDateTimePicker();


//                final Calendar c;
//                int hour = 0;
//                int minute = 0;
//
//                    c = Calendar.getInstance();
//                    hour = c.get(android.icu.util.Calendar.HOUR_OF_DAY);
//                    minute = c.get(Calendar.MINUTE);
//
//
//                // on below line we are getting our hour, minute.
//
//
//                TimePickerDialog timePickerDialog = new TimePickerDialog(Customer_carpool_map.this,
//                        new TimePickerDialog.OnTimeSetListener() {
//                            @Override
//                            public void onTimeSet(TimePicker view, int hourOfDay,
//                                                  int minute) {
//                                // set selected time in our preferences
//                                String timeString = String.format("%02d:%02d",hourOfDay,minute);
//
//
//
//
//                            }
//                        }, hour, minute, false);
//
//                timePickerDialog.show();
////                timePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(getContext(), R.color.theme_color));
////                timePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(getContext(), R.color.btn_color));

            }
        });
//        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.setNavigationBarColor(0xFFFFFFFF);
//        window.setStatusBarColor(0xFFFFFFFF);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    public void showDateTimePicker() {
        final Calendar currentDate;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            currentDate = Calendar.getInstance();
            date = Calendar.getInstance();


            new DatePickerDialog(Customer_carpool_map.this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        date.set(year, monthOfYear, dayOfMonth);
                    }
                    new TimePickerDialog(Customer_carpool_map.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                date.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                date.set(Calendar.MINUTE, minute);
                            }

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                Log.v(TAG, "The choosen one " + date.getTime());
                            }
                        }
                    }, currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), false).show();
                }
            }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
        }
    }
}