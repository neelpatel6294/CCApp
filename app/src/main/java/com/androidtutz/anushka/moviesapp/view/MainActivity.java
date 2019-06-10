package com.androidtutz.anushka.moviesapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidtutz.anushka.moviesapp.R;
import com.androidtutz.anushka.moviesapp.ViewModel.MainActivityViewModel;
import com.androidtutz.anushka.moviesapp.adapter.MovieAdapter;
import com.androidtutz.anushka.moviesapp.model.RelatedTopic;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ArrayList<RelatedTopic> movies = new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private SwipeRefreshLayout swipeContainer;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(" TMDb Popular Movies Today");

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        getPopularMoviesRx();
        swipeContainer = findViewById(R.id.swipe_layout);
        swipeContainer.setColorSchemeResources(R.color.colorPrimary);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMoviesRx();
            }
        });


    }


    public void getPopularMoviesRx() {

        mainActivityViewModel.getAllMovies().observe(this, new Observer<List<RelatedTopic>>() {
            @Override
            public void onChanged(@Nullable List<RelatedTopic> moviesList) {
                movies = (ArrayList<RelatedTopic>) moviesList;
                init();
            }
        });


    }

    public void init() {


        recyclerView = findViewById(R.id.rvMovies);
        movieAdapter = new MovieAdapter(this, movies);


//        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        } else {
//            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
//        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mainActivityViewModel.clear();

    }
}


