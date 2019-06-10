package com.sample.comcast.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sample.comcast.moviesapp.R;
import com.sample.comcast.model.Icon;
import com.sample.comcast.model.RelatedTopic;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView movieTitle,
            movieSynopsis, movieRating, movieReleaseDate;
    ImageView movieImage;
    RatingBar ratingBar;
    Button rateButton;

    RelatedTopic movie;
    public String image, name, synopsis, rating, date, myRating;
    int id;
    Icon mIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initCollapsingToolbar();

        movieImage = findViewById(R.id.detail_char_imageVIew);
        movieTitle = findViewById(R.id.detail_char_textView);
//        movieSynopsis = findViewById(R.id.tvPlotsynopsis);
//        movieRating = findViewById(R.id.tvMovieRating);
//        movieReleaseDate = findViewById(R.id.tvReleaseDate);
//        ratingBar = findViewById(R.id.ratingBar);
//        rateButton = findViewById(R.id.btnRating);


        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra("main_data")) {

            movie = getIntent().getParcelableExtra("main_data");

//            image = movie.getPosterPath();
            name = movie.getText();
            mIcon = movie.getIcon();
//            synopsis = movie.getOverview();
//            rating = Double.toString(movie.getVoteAverage());
//            date = movie.getReleaseDate();
//            id = movie.getId();

//            String poster = "https://image.tmdb.org/t/p/w500" + image;

            Glide.with(this)
                    .load(mIcon.getURL())
                    .placeholder(R.drawable.ic_baseline_accessibility_new_24px)
                    .into(movieImage);

            movieTitle.setText(name);
//            movieSynopsis.setText(synopsis);
//            movieRating.setText(rating);
//            movieReleaseDate.setText(date);

        } else {
            Toast.makeText(this, "No movie data found", Toast.LENGTH_SHORT).show();
        }


    }


    private void initCollapsingToolbar() {

        final CollapsingToolbarLayout collapsingToolbarLayout =
                findViewById(R.id.collapsingtoolbar);
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.app_bar);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    // collapsingToolbarLayout.setTitle(getString(R.string.movie_info));
                    collapsingToolbarLayout.setTitle(name);
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }


}
