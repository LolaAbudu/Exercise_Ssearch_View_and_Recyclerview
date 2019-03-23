package org.pursuit.exercisessearchviewandrecyclerview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import org.pursuit.exercisessearchviewandrecyclerview.controller.PlanetAdapter;
import org.pursuit.exercisessearchviewandrecyclerview.model.Planet;
import org.pursuit.exercisessearchviewandrecyclerview.model.PlanetList;
import org.pursuit.exercisessearchviewandrecyclerview.network.PlanetService;
import org.pursuit.exercisessearchviewandrecyclerview.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private SearchView searchView;
    private PlanetAdapter planetAdapter;
    private List<Planet> planetList;
    //private Retrofit retrofit;




    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //planetList = new ArrayList<>();
        recyclerView = findViewById(R.id.planet_recycler_view);
        searchView = findViewById(R.id.planet_search_view);

        //planetAdapter = new PlanetAdapter(planetList);
        //recyclerView.setAdapter(planetAdapter);
        planetList = new ArrayList<>();

        searchView.setOnQueryTextListener(this);


        RetrofitSingleton.getOneInstance()
                .create(PlanetService.class)
                .getPlanetResponse().enqueue(new Callback<PlanetList>() {
            @Override
            public void onResponse(Call<PlanetList> call, Response<PlanetList> response) {
                Log.d("TAG", "onResponse" + response.body().getPlanetList());
                planetList = response.body().getPlanetList();

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                planetAdapter = new PlanetAdapter(planetList);
                recyclerView.setAdapter(planetAdapter);

            }

            @Override
            public void onFailure(Call<PlanetList> call, Throwable t) {
                Log.d("TAG", "onFailure" + t.getMessage());
            }
        });
//
//        RetrofitSingleton.getOneInstance()
//                .create(PlanetService.class)
//                .getPlanetResponse()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                //.map(PlanetList::getPlanetList)
//                .subscribe(
//                        planet -> {
//                           planetList = new ArrayList<>();
//                            planetList.add(planet.getPlanetList().get(0));
//                            Log.d("TAG", "onResponse" + planet);
//
//                            planetAdapter = new PlanetAdapter(planetList);
//                            recyclerView.setAdapter(planetAdapter);
//                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                        },
//                        throwable -> Log.d("TAG", "onFailure" + throwable));
        //PlanetsWrapper::getPlanets

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String userInput) {
        List<Planet> newPlanetList = new ArrayList<>();
        for(Planet planet : planetList){
            if(planet.getName().toLowerCase().startsWith(userInput.toLowerCase())){
                newPlanetList.add(planet);
            }
        }
        planetAdapter.setData(newPlanetList);
        return false;
    }
}
