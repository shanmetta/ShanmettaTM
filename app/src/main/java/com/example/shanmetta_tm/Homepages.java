package com.example.shanmetta_tm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Homepages extends AppCompatActivity {

    ListView listView;

    String lhotelName[] = {"NEO+", "Horison", "Grand Setiabudi"};
    String lhotelAlamat[] = {"Kebayoran", "Ciledug", "Jakarta"};
    String lhotelPrice[] = {"364.000/night", "500.000/night", "650.000/night"};
    String lhotelPrice2[] = {"364000", "500000", "650000"};
    int limage[] = {R.drawable.hotelneo, R.drawable.hotelhorison, R.drawable.hotelsetiabudi};
    String llongitude[] = {"106.77609", "106.744531", "107.5949251"};
    String llatitude[] ={"-6.2377162", "-6.2364611", "-6.8748216"};
    String lphone[]={"02122777888", "02130487700", "0222044002"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepages);

       Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listView = findViewById(R.id.List_view);
        HotelAdapter adapter = new HotelAdapter(this, lhotelName, lhotelAlamat, lhotelPrice, limage);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent(getApplicationContext(),detailhotel.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("gambarhotel",limage[0]);
                    intent.putExtras(bundle);

                    intent.putExtra("namahotel",lhotelName[0]);
                    intent.putExtra("alamathotel",lhotelAlamat[0]);
                    intent.putExtra("hargahotel",lhotelPrice[0]);
                    intent.putExtra("latitudehotel",llatitude[0]);
                    intent.putExtra("longitudehotel",llongitude[0]);
                    intent.putExtra("nopehotel", lphone[0]);
                    intent.putExtra("price", lhotelPrice2[0]);

                    intent.putExtra("position", ""+0);
                    startActivity(intent);
                }
                else if (position==1){
                    Intent intent = new Intent(getApplicationContext(),detailhotel.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("gambarhotel",limage[1]);
                    intent.putExtras(bundle);

                    intent.putExtra("namahotel",lhotelName[1]);
                    intent.putExtra("alamathotel",lhotelAlamat[1]);
                    intent.putExtra("hargahotel",lhotelPrice[1]);
                    intent.putExtra("latitudehotel",llatitude[1]);
                    intent.putExtra("longitudehotel",llongitude[1]);
                    intent.putExtra("nopehotel", lphone[1]);
                    intent.putExtra("price", lhotelPrice2[1]);

                    intent.putExtra("position", ""+1);
                    startActivity(intent);
                }
                else if (position==2){
                     Intent intent = new Intent(getApplicationContext(),detailhotel.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("gambarhotel",limage[2]);
                    intent.putExtras(bundle);

                    intent.putExtra("namahotel",lhotelName[2]);
                    intent.putExtra("alamathotel",lhotelAlamat[2]);
                    intent.putExtra("hargahotel",lhotelPrice[2]);
                    intent.putExtra("latitudehotel",llatitude[2]);
                    intent.putExtra("longitudehotel",llongitude[2]);
                    intent.putExtra("nopehotel", lphone[2]);
                    intent.putExtra("price", lhotelPrice2[2]);

                    intent.putExtra("position", ""+2);
                    startActivity(intent);
                }

            }
        });
    }



     @Override
      public boolean onCreateOptionsMenu(Menu menu) {
          MenuInflater inflater = getMenuInflater();
          inflater.inflate(R.menu.menu_item, menu);
          return true;
      }

      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {
          switch (item.getItemId()){
              case R.id.item1:
              Intent intent  = new  Intent(Homepages.this, mybooking.class);
              startActivity(intent);
              return true;

              case R.id.item2:
                  Intent intent2  = new  Intent(Homepages.this, MainActivity.class);
                  startActivity(intent2);
                  return true;


          }
  
  
          return super.onOptionsItemSelected(item);
      }

    class HotelAdapter extends ArrayAdapter<String>{

        Context context;
        String ahotelName[];
        String ahotelAlamat[];
        String ahotelPrice[];
        int aimage[];

        HotelAdapter(Context c, String hotelName[], String hotelAddress[], String hotelPrice[], int Image[]){
            super(c, R.layout.activity_isirow, R.id.hotelname_txt, hotelName);
            this.context=c;
            this.ahotelName= hotelName;
            this.ahotelAlamat = hotelAddress;
            this.ahotelPrice = hotelPrice;
            this.aimage = Image;

        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.activity_isirow, parent, false);
            ImageView images = row.findViewById(R.id.gambarHotel);
            TextView namaHotel = row.findViewById(R.id.hotelname_txt);
            TextView alamatHotel = row.findViewById(R.id.addresshotel_txt);
            TextView hargaHotel = row.findViewById(R.id.pricehotel_txt);

            images.setImageResource(aimage[position]);
            namaHotel.setText(ahotelName[position]);
            alamatHotel.setText(ahotelAlamat[position]);
            hargaHotel.setText(ahotelPrice[position]);



            return row;
        }

    }
}
