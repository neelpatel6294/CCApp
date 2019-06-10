package com.sample.comcast.service;


import com.sample.comcast.model.One;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataService {


    @GET("?q=simpsons+characters&format=json")
    Observable<One> getCharacterData();


}
