package org.pursuit.exercisessearchviewandrecyclerview.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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
        return new PlanetViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_itemview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
