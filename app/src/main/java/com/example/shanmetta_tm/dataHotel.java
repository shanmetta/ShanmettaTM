package com.example.shanmetta_tm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class dataHotel {

    String hotelName;
    String hotelAlamat;
    String Checkin;
    String Checkout;
    String Total;

    public  dataHotel(String hotelName, String hotelAlamat, String checkin, String checkout, String total){
        this.hotelName = hotelName;
        this.hotelAlamat = hotelAlamat;
        this.Checkin = checkin;
        this.Checkout = checkout;
        this.Total = total;
    }

    public String getHotelName() {
        return hotelName;
    }


    public String getHotelAlamat() {
        return hotelAlamat;
    }



    public String getCheckin() {
        return Checkin;
    }



    public String getCheckout() {
        return Checkout;
    }



    public String getTotal() {
        return Total;
    }

}
