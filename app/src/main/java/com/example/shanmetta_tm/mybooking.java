package com.example.shanmetta_tm;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class mybooking extends AppCompatActivity {


    List<dataHotel> hotelList;

    ListView listView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybooking);

        hotelList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.List_vview);


        hotelList.add(new dataHotel("NEO+", "Kebayoran","23-11-2019","24-11-2019", "Rp 3.509.000"));
        hotelList.add(new dataHotel("Horison", "Ciledug","24-12-2019","28-12-2019","Rp 12.105.260"));
        hotelList.add(new  dataHotel("Grand Setiabudi", "Jakarta","24-12-2019","25-12-2019","Rp 2.896.341"));



        hotelListAdapter adapter = new hotelListAdapter(this, R.layout.activity_isimybooking, hotelList);

        listView.setAdapter(adapter);




    }


}
