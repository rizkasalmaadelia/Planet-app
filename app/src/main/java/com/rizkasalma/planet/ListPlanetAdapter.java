package com.rizkasalma.planet;

import android.app.ListActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPlanetAdapter extends RecyclerView.Adapter<ListPlanetAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Planet> listPlanet;
    public ArrayList<Planet> getListPlanet() {
        return listPlanet;
    }
    public void setListPlanet(ArrayList<Planet> listPlanet) {
        this.listPlanet = listPlanet;
    }

    public ListPlanetAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemrowplanet, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.textplanet.setText(getListPlanet().get(position).getNama());
        categoryViewHolder.des.setText(getListPlanet().get(position).getDes());
        categoryViewHolder.jarak.setText(getListPlanet().get(position).getJarak());
        categoryViewHolder.textplanet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               

            }
        });

        Glide.with(context)
                .load(getListPlanet().get(position).getPhoto())
                .apply(new RequestOptions().override(60,60))
                .into(categoryViewHolder.photoplanet);
    }

    @Override
    public int getItemCount() {
        return getListPlanet().size();
    }


    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView textplanet,des,jarak;
        ImageView photoplanet;

        CategoryViewHolder(@NonNull View itemView){
            super(itemView);
            textplanet = itemView.findViewById(R.id.textplanet);
            des = itemView.findViewById(R.id.deskripsi);
            photoplanet = itemView.findViewById(R.id.planetpic);
            jarak = itemView.findViewById(R.id.jarakdepan);
        }
    }
}
