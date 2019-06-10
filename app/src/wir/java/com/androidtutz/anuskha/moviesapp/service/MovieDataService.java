package com.androidtutz.anuskha.moviesapp.service;


import com.androidtutz.anushka.moviesapp.model.One;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 7/9/2018.
 */
public interface MovieDataService {


    @GET("?q=simpsons+characters&format=json")
    Observable<One> getPopularMovies();


}
