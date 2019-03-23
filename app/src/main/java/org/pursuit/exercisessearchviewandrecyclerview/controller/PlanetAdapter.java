package org.pursuit.exercisessearchviewandrecyclerview.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.exercisessearchviewandrecyclerview.R;
import org.pursuit.exercisessearchviewandrecyclerview.model.Planet;
import org.pursuit.exercisessearchviewandrecyclerview.view.PlanetViewHolder;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetViewHolder> {

    private List<Planet> planetList;

    public PlanetAdapter(List<Planet> planetList) {
        this.planetList = planetList;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_itemview, parent, false);
        return new PlanetViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int position) {
        planetViewHolder.onBind(planetList.get(position));
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public void setData(List<Planet> newPlanetList){
        this.planetList = newPlanetList;
        notifyDataSetChanged();
    }
}
