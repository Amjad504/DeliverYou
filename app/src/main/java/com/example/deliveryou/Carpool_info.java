package com.example.deliveryou;

import android.widget.ImageView;

public class Carpool_info {


    String C_ID,Customer_Name,Pickup,Dropoff,Pickup_Time,Estimated_TIme,Total_Time;
    String Customer_Pic;
    int Rating;

    public Carpool_info(String c_ID, String customer_Name, String customer_Pic, String pickup, String dropoff, String pickup_Time, String estimated_TIme, String total_Time, int rating) {
        C_ID = c_ID;
        Customer_Name = customer_Name;
        Customer_Pic = customer_Pic;
        Pickup = pickup;
        Dropoff = dropoff;
        Pickup_Time = pickup_Time;
        Estimated_TIme = estimated_TIme;
        Total_Time = total_Time;
        Rating = rating;
    }

    public String getC_ID() {
        return C_ID;
    }

    public void setC_ID(String c_ID) {
        C_ID = c_ID;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String  getCustomer_Pic() {
        return Customer_Pic;
    }

    public void setCustomer_Pic(String customer_Pic) {
        Customer_Pic = customer_Pic;
    }

    public String getPickup() {
        return Pickup;
    }

    public void setPickup(String pickup) {
        Pickup = pickup;
    }

    public String getDropoff() {
        return Dropoff;
    }

    public void setDropoff(String dropoff) {
        Dropoff = dropoff;
    }

    public String getPickup_Time() {
        return Pickup_Time;
    }

    public void setPickup_Time(String pickup_Time) {
        Pickup_Time = pickup_Time;
    }

    public String getEstimated_TIme() {
        return Estimated_TIme;
    }

    public void setEstimated_TIme(String estimated_TIme) {
        Estimated_TIme = estimated_TIme;
    }

    public String getTotal_Time() {
        return Total_Time;
    }

    public void setTotal_Time(String total_Time) {
        Total_Time = total_Time;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }
}

