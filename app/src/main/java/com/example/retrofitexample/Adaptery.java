package com.example.retrofitexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    String TAG = Adaptery.class.getSimpleName();
    private Context mContext;
    private List<Hero> heroes;

    public Adaptery(Context mContext, List<Hero> heroes) {
        this.mContext = mContext;
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: "+heroes);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file, parent, false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.name.setText(heroes.get(position).getName());
        holder.name2.setText(heroes.get(position).getRealname());

        Glide.with(mContext).load(heroes.get(position).getImageurl())
                .into(holder.img);


    }

    @Override
    public int getItemCount() {

        return heroes.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView name2;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            name2 = itemView.findViewById(R.id.name2);
            img = itemView.findViewById(R.id.img);

        }
    }

}
