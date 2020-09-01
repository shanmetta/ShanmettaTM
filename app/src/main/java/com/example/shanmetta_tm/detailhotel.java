package com.example.shanmetta_tm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class detailhotel extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView namahotel, alamathotel, phonehotel, pricehotel, latitudehotel, longitudehotel;
    ImageView gambar;
    int position, harga;
    boolean startOrEnd = true;
    Button checkinBtn;
    Button checkoutBtn;
    Button bookBtn;
    TextView checkinTxt;
    TextView checkOutTxt;
    TextView totalpriceTxt;
    String date;
    int year;
    int month;
    int day;
    private Object Double;
    private  boolean isDatee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailhotel);

        namahotel = findViewById(R.id.hotelname_txt);
        alamathotel = findViewById(R.id.addresshotel_txt);
        phonehotel = findViewById(R.id.hotel_phone);
        gambar = findViewById(R.id.gambarHotel);
        latitudehotel = findViewById(R.id.hotel_latitude);
        longitudehotel = findViewById(R.id.hotel_longitude);
        pricehotel = findViewById(R.id.pricehotel_txt);
        checkinBtn = findViewById(R.id.checkin_btn);
        checkoutBtn = findViewById(R.id.checkout_btn2);
        checkinTxt = findViewById(R.id.checkin_txt);
        checkOutTxt = findViewById(R.id.checkout_txt);
        totalpriceTxt = findViewById(R.id.totalprice_txt);
        bookBtn = findViewById(R.id.book_btn);

        final String checkinn = checkinTxt.getText().toString();
        String checkoutt = checkOutTxt.getText().toString();


        if (position == 0) {


            Intent intent = getIntent();
            Bundle bundle = this.getIntent().getExtras();

            String bhotelname = intent.getStringExtra("namahotel");
            namahotel.setText(bhotelname);

            int bgambar = bundle.getInt("gambarhotel");
            gambar.setImageResource(bgambar);

            String bhotelalamat = intent.getStringExtra("alamathotel");
            alamathotel.setText(bhotelalamat);

            String bhotelphone = intent.getStringExtra("nopehotel");
            phonehotel.setText(bhotelphone);

            String blatitude = intent.getStringExtra("latitudehotel");
            latitudehotel.setText(blatitude);

            String blongitude = intent.getStringExtra("longitudehotel");
            longitudehotel.setText(blongitude);

            String bpricehotel = intent.getStringExtra("hargahotel");
            pricehotel.setText(bpricehotel);

            String bprice = intent.getStringExtra("price");
            harga = Integer.parseInt(bprice);

        } else if (position == 1) {

            Intent intent = getIntent();
            Bundle bundle = this.getIntent().getExtras();
            int bgambar = bundle.getInt("gambarhotel");
            gambar.setImageResource(bgambar);

            String bhotelname = intent.getStringExtra("namahotel");
            namahotel.setText(bhotelname);

            String bhotelalamat = intent.getStringExtra("alamathotel");
            alamathotel.setText(bhotelalamat);

            String bhotelphone = intent.getStringExtra("nopehotel");
            phonehotel.setText(bhotelphone);

            String blatitude = intent.getStringExtra("latitudehotel");
            latitudehotel.setText(blatitude);

            String blongitude = intent.getStringExtra("longitudehotel");
            longitudehotel.setText(blongitude);

            String bpricehotel = intent.getStringExtra("hargahotel");
            pricehotel.setText(bpricehotel);

            String bprice = intent.getStringExtra("price");
            harga = Integer.parseInt(bprice);

        } else if (position == 2) {

            Intent intent = getIntent();
            Bundle bundle = this.getIntent().getExtras();
            int bgambar = bundle.getInt("gambarhotel");
            gambar.setImageResource(bgambar);

            String bhotelname = intent.getStringExtra("namahotel");
            namahotel.setText(bhotelname);

            String bhotelalamat = intent.getStringExtra("alamathotel");
            alamathotel.setText(bhotelalamat);

            String bhotelphone = intent.getStringExtra("nopehotel");
            phonehotel.setText(bhotelphone);

            String blatitude = intent.getStringExtra("latitudehotel");
            latitudehotel.setText(blatitude);

            String blongitude = intent.getStringExtra("longitudehotel");
            longitudehotel.setText(blongitude);

            String bpricehotel = intent.getStringExtra("hargahotel");
            pricehotel.setText(bpricehotel);

            String bprice = intent.getStringExtra("price");
            harga = Integer.parseInt(bprice);

        }


        checkinBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                showDatePickerDialog();
                startOrEnd = true;
            }
        });

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
                startOrEnd = false;
            }
        });


    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(


                this, this, Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


        String myDate = "mm/dd/yyyy";


        month = month + 1;
        String date = month + "/" + dayOfMonth + "/" + year;
        if (startOrEnd) {
            checkinTxt.setText(date);
        } else {
            checkOutTxt.setText(date);
        }



        try {

            DateFormat tanggal = new SimpleDateFormat(myDate);
            Date today = new  Date();
            today.getTime();

            Date tanggalchekin = tanggal.parse(checkinTxt.getText().toString());
            Date tanggalcheckout = tanggal.parse(checkOutTxt.getText().toString());

         //   Log.v("CHECKIN", tanggalchekin + "");
          //  Log.v("CHECKOUT", tanggalcheckout + "");


            if(today.after(tanggalchekin)){
                Toast.makeText(detailhotel.this, "check-in date must not be earlier than today", Toast.LENGTH_SHORT).show();
           } else if(tanggalchekin.after(tanggalcheckout)) {
               Toast.makeText(detailhotel.this, "check-out date must not be earlier than check-in date.", Toast.LENGTH_SHORT).show();
            }else{
                long day1 = tanggalchekin.getTime();
                long day2 = tanggalcheckout.getTime();
                long shari = day2 - day1;
                long day = shari;
                long thari = shari / (24 * 60 * 60 * 1000) * harga;
                String totalharga = Long.toString(thari);
                totalpriceTxt.setText(totalharga);


                bookBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(detailhotel.this, Homepages.class);
                        startActivity(intent);
                    }
                });
            }

        } catch (ParseException e) {
            e.printStackTrace();

        }


    }



}




