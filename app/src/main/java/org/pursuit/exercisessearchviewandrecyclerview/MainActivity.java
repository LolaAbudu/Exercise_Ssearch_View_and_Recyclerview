package org.pursuit.exercisessearchviewandrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import org.pursuit.exercisessearchviewandrecyclerview.controller.PlanetAdapter;
import org.pursuit.exercisessearchviewandrecyclerview.network.PlanetService;
import org.pursuit.exercisessearchviewandrecyclerview.network.RetrofitSingleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    SearchView searchView;
    PlanetAdapter planetAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.planet_recycler_view);
        searchView = findViewById(R.id.planet_search_view);

        RetrofitSingleton.getOneInstance()
                .create(PlanetService.class)
                .getPlanet()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        planet -> {

                        },
                        throwable -> Log.d("TAG", "onFailure" + throwable));

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(planetAdapter);
    }
}
