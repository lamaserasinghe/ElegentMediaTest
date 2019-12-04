package com.example.elegant_media;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.elegant_media.REST_Classes.Details;
import com.example.elegant_media.REST_Classes.Image;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

//Create hoteldata adapter for binding data with ListView.
public class HotelDataAdapter extends RecyclerView.Adapter<HotelDataAdapter.HotelDataViewHolder>{
    private Context mCtx;
    private List<Details> dataList;
    private List<Image> imageList;

    //constructor
    public HotelDataAdapter(Context mCtx, List<Details> dataList) {
        this.mCtx = mCtx;
        this.dataList = dataList;

    }

    class HotelDataViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitle;
        TextView txtAddress;
        private ImageView image;

        HotelDataViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtAddress = mView.findViewById(R.id.address);
            txtTitle = mView.findViewById(R.id.title);
            image = mView.findViewById(R.id.image);
        }
    }

    @Override
    public HotelDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.details_activity, parent, false);
        return new HotelDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HotelDataViewHolder holder, int position) {
        //binding the data with the viewholder views
        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.txtAddress.setText(dataList.get(position).getAddress());
        Picasso.get().load(String.valueOf(dataList.get(position))).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}



