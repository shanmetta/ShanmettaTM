package com.example.shanmetta_tm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class hotelListAdapter extends ArrayAdapter<dataHotel> {


    List<dataHotel> hotelList;
    Context context;
    int resource;

    public  hotelListAdapter(Context context, int resource, List<dataHotel> hotelList){
        super(context, resource, hotelList);
        this.context = context;
        this.resource = resource;
        this.hotelList = hotelList;

    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View row = layoutInflater.inflate(R.layout.activity_isimybooking, null, false);
        TextView namaHotel = row.findViewById(R.id.hotelnme_txt);
        TextView alamatHotel = row.findViewById(R.id.almt_txt);
        TextView checkin = row.findViewById(R.id.cekin_txt);
        TextView checkout = row.findViewById(R.id.cekout_txt);
        TextView total = row.findViewById(R.id.total_txt);
        Button cancel = row.findViewById(R.id.cancel_btn);


        dataHotel hotel = hotelList.get(position);

        //Resources res = context.getResources();
        namaHotel.setText(hotel.getHotelName());
        alamatHotel.setText(hotel.getHotelAlamat());
        checkin.setText(hotel.getCheckin());
        checkout.setText(hotel.getCheckout());
        total.setText(hotel.getTotal());


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removelist(position);
            }
        });


        return row;


    }

    private void removelist(final  int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure want do delete this?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"Has been Remove",Toast.LENGTH_SHORT).show();
                hotelList.remove(position);
                notifyDataSetChanged();
            }


        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
