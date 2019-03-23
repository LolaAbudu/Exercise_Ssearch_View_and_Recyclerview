package org.pursuit.exercisessearchviewandrecyclerview.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.exercisessearchviewandrecyclerview.R;
import org.pursuit.exercisessearchviewandrecyclerview.model.Planet;

public class PlanetViewHolder extends RecyclerView.ViewHolder {

    private TextView planetNameTextView;
    //private TextView planetNumberTextView;
    private ImageView planetImageView;

    public PlanetViewHolder(@NonNull View itemView) {
        super(itemView);

        planetNameTextView = itemView.findViewById(R.id.name_text_view);
        //planetNumberTextView = itemView.findViewById(R.id.number_text_view);
        planetImageView = itemView.findViewById(R.id.image_text_view);
    }

    public void onBind(Planet planet){
        setViews(planet);
    }

    private void setViews(Planet planet) {
        planetNameTextView.setText(planet.getName());
        //planetNumberTextView.setText(String.valueOf(planet.getNumber()));
        Picasso.get().load(planet.getImage()).into(planetImageView);
    }
}
