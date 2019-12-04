package com.example.elegant_media;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.elegant_media.REST_Classes.Details;

import java.io.IOError;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadDetailsActivity extends AppCompatActivity {
    public HotelDataAdapter adapter;
    private List<Details> detailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_details);

        final ListView list = findViewById(R.id.list);
        ArrayList<Details> arrayList = new ArrayList<Details>();
        String[] title = new String[arrayList.size()];
        String[] address = new String[arrayList.size()];
        String[] image = new String[arrayList.size()];

        for(int i=0;i<arrayList.size();i++){

            title[i]=arrayList.get(i).getTitle(); // getting titles
            address[i]=arrayList.get(i).getAddress(); // getting address
            image[i]=arrayList.get(i).getImage(); // getting images

        }

        HotelDataAdapter hotelDataAdapter = new HotelDataAdapter(this, arrayList);


        //API call
        ApiInterface apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        Call call=apiInterface.getHotelDetails();

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                try{
                    if(response.body()!=null){

                        detailsList=(List<Details>)response.body();
                        adapter = new HotelDataAdapter(LoadDetailsActivity.this, detailsList);


                    }
                    else{
                        Toast.makeText(getApplicationContext(),"No results found...",Toast.LENGTH_LONG).show();
                    }
                }
                catch (IOError error){
                    error.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
               // progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"No internet connection...",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
