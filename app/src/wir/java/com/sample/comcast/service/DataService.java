package com.sample.comcast.service;


import com.sample.comcast.model.One;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface DataService {


    @GET("?q=the+wire+characters&format=json")
    Observable<One> getCharacterData();


}
