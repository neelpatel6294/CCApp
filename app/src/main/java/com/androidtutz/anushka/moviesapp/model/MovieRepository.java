package com.androidtutz.anushka.moviesapp.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import com.androidtutz.anushka.moviesapp.service.RetrofitInstance;
import com.androidtutz.anuskha.moviesapp.service.MovieDataService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class MovieRepository {

    private Application application;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<RelatedTopic>> moviesLiveData = new MutableLiveData<>();
    private ArrayList<RelatedTopic> movies;
    private Observable<One> movieDBResponseObservable;

    public MovieRepository(Application application) {
        this.application = application;


    }

    public MutableLiveData<List<RelatedTopic>> getMoviesLiveData() {

        movies = new ArrayList<>();
        MovieDataService getMoviesDataService = RetrofitInstance.getService();
        movieDBResponseObservable = getMoviesDataService.getPopularMovies();

        compositeDisposable.add(movieDBResponseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<One, Observable<RelatedTopic>>() {
                    @Override
                    public Observable<RelatedTopic> apply(One movieDBResponse) throws Exception {
                        return Observable.fromArray(movieDBResponse.getRelatedTopics().toArray(new RelatedTopic[0]));
                    }
                })
//                .filter(new Predicate<Movie>() {
//                    @Override
//                    public boolean test(Movie movie) throws Exception {
//                        return movie.getVoteAverage()>7.0;
//                    }
//                })
                .subscribeWith(new DisposableObserver<RelatedTopic>() {
                    @Override
                    public void onNext(RelatedTopic movie) {
                        movies.add(movie);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        moviesLiveData.postValue(movies);
                    }
                }));
        return moviesLiveData;
    }

    public void clear() {
        compositeDisposable.clear();
    }
}
