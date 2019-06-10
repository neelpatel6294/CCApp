package com.androidtutz.anushka.moviesapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.androidtutz.anushka.moviesapp.model.MovieRepository;
import com.androidtutz.anushka.moviesapp.model.RelatedTopic;

import java.util.List;


public class MainActivityViewModel extends AndroidViewModel {

   private MovieRepository movieRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        movieRepository=new MovieRepository(application);
    }

    public LiveData<List<RelatedTopic>> getAllMovies(){

        return  movieRepository.getMoviesLiveData();
    }

    public void clear(){

        movieRepository.clear();
    }

}
