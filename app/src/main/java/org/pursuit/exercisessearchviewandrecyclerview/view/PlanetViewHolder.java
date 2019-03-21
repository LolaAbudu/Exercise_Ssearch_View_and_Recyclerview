package org.pursuit.exercisessearchviewandrecyclerview.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.exercisessearchviewandrecyclerview.R;
import org.pursuit.exercisessearchviewandrecyclerview.model.Planet;

public class PlanetViewHolder extends RecyclerView.ViewHolder {

    private TextView planetTextView;

    public PlanetViewHolder(@NonNull View itemView) {
        super(itemView);

        planetTextView = itemView.findViewById(R.id.planet_text_view);
    }

    public void onBind(Planet planet){
        planetTextView.setText(planet.getName());
    }
}
