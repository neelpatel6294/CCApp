package com.sample.comcast.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.sample.comcast.model.CharacterRepository;
import com.sample.comcast.model.RelatedTopic;

import java.util.List;


public class MainActivityViewModel extends AndroidViewModel {

    private CharacterRepository mRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mRepository = new CharacterRepository(application);
    }

    public LiveData<List<RelatedTopic>> getAllData() {

        return mRepository.getCharacterLiveData();
    }



    public void clear() {

        mRepository.clear();
    }

}
