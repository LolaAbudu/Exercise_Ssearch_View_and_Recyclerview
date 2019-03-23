package org.pursuit.exercisessearchviewandrecyclerview.network;

import org.pursuit.exercisessearchviewandrecyclerview.model.PlanetList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlanetService {
    String END_POINT = "JDVila/storybook/master/planets.json";

    @GET(END_POINT)
    Call<PlanetList> getPlanetResponse();
}
