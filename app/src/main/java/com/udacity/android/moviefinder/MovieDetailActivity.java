package com.udacity.android.moviefinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ImageView movieIv = (ImageView) findViewById(R.id.detail_movie_image);
        TextView detailTitle = (TextView) findViewById(R.id.tv_detail_movie_title);
        TextView detailOverview = (TextView) findViewById(R.id.tv_detail_overview);
        RatingBar detailRating = (RatingBar) findViewById(R.id.detail_rating);
        TextView detailReleaseDate = (TextView) findViewById(R.id.detail_release_date);

        intent = getIntent();

        detailTitle.setText(getMovieValue("title"));
        detailOverview.setText(getMovieValue("overview"));
        detailRating.setRating(Float.parseFloat(getMovieValue("rating")));
        detailRating.setIsIndicator(true);
        detailReleaseDate.setText(getMovieValue("date"));
        Picasso.with(this.getBaseContext())
                .load(getMovieValue("image"))
                .into(movieIv);

    }

    private String getMovieValue(String key) {
        return intent.getExtras().getString(key);
    }
}
