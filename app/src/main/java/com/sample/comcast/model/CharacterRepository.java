package com.sample.comcast.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import com.sample.comcast.adapter.DataAdapter;
import com.sample.comcast.service.RetrofitInstance;
import com.sample.comcast.service.DataService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class CharacterRepository {


    private Application application;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<RelatedTopic>> characterLiveData = new MutableLiveData<>();
    private ArrayList<RelatedTopic> dataList;
    private Observable<One> characterResponseObservable;

    public CharacterRepository(Application application) {
        this.application = application;


    }
//
//
//    public MutableLiveData<List<RelatedTopic>> getFilteredData() {
//
//        compositeDisposable.add(RxTextView.textChangeEvents(search)
//                .skipInitialValue()
//                .debounce(300, TimeUnit.MILLISECONDS)
//                /*.filter(new Predicate<TextViewTextChangeEvent>() {
//                    @Override
//                    public boolean test(TextViewTextChangeEvent textViewTextChangeEvent) throws Exception {
//                        return TextUtils.isEmpty(textViewTextChangeEvent.text().toString()) || textViewTextChangeEvent.text().toString().length() > 2;
//                    }
//                })*/
//                .distinctUntilChanged()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableObserver<TextViewTextChangeEvent>() {
//                    @Override
//                    public void onNext(TextViewTextChangeEvent textViewTextChangeEvent) {
//                        dataList.clear();
//                        mAdapter.getFilter().filter(textViewTextChangeEvent.text());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                }));
//
//
//        return characterLiveData;
//    }

    public MutableLiveData<List<RelatedTopic>> getCharacterLiveData() {

        dataList = new ArrayList<>();
        DataService getDataService = RetrofitInstance.getService();
        characterResponseObservable = getDataService.getCharacterData();

        compositeDisposable.add(characterResponseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<One, Observable<RelatedTopic>>() {
                    @Override
                    public Observable<RelatedTopic> apply(One charResponse) throws Exception {
                        return Observable.fromArray(charResponse.getRelatedTopics().toArray(new RelatedTopic[0]));
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
                        dataList.add(movie);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        characterLiveData.postValue(dataList);
                    }
                }));
        return characterLiveData;
    }



    public void clear() {
        compositeDisposable.clear();
    }
}
