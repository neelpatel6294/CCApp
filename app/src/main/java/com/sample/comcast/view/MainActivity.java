package com.sample.comcast.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.sample.comcast.moviesapp.R;
import com.sample.comcast.ViewModel.MainActivityViewModel;
import com.sample.comcast.adapter.DataAdapter;
import com.sample.comcast.model.RelatedTopic;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ArrayList<RelatedTopic> charList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;
    private EditText mSearchBar;
    private MainActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Simsons");


        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        getCharData();
        mSearchBar = findViewById(R.id.search_bar);
//        swipeContainer = findViewById(R.id.swipe_layout);
//        swipeContainer.setColorSchemeResources(R.color.colorPrimary);
//        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                getCharData();
//            }
//        });
    }

    public void getCharData() {

        mViewModel.getAllData().observe(this, new Observer<List<RelatedTopic>>() {
            @Override
            public void onChanged(@Nullable List<RelatedTopic> dataList) {
                charList = (ArrayList<RelatedTopic>) dataList;
                init();
            }
        });
    }

    public void init() {


        recyclerView = findViewById(R.id.rvChar);
        dataAdapter = new DataAdapter(this, charList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(dataAdapter);
        dataAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mViewModel.clear();

    }


}


