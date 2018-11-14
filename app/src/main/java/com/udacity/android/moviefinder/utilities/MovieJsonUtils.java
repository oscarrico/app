package com.udacity.android.moviefinder.utilities;

import android.util.Log;

import com.udacity.android.moviefinder.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieJsonUtils {

    private static final String TAG = MovieJsonUtils.class.getSimpleName();

    private static final String RELEASE_DATE = "release_date";
    private static final String OVERVIEW = "overview";
    private static final String RATING = "vote_average";
    private static final String IMAGE_PATH = "backdrop_path";
    private static final String TITLE = "title";
    private static final String RESULTS = "results";
    private static final String IMAGE_DB_URL = "https://image.tmdb.org/t/p/w500";


    public static List<Movie> getMovieDataFromJson(String movieResponseJsonStr)
            throws JSONException {

        JSONObject movieListJson = new JSONObject(movieResponseJsonStr);
        JSONArray movieJsonArray = movieListJson.getJSONArray(RESULTS);
        List<Movie> movieList = new ArrayList<>();

        for(int i = 0; i < movieJsonArray.length(); i++) {
            JSONObject movieJson = movieJsonArray.getJSONObject(i);

            Movie movie = new Movie();
            String imagePath = movieJson.getString(IMAGE_PATH);
            if(imagePath != null && !imagePath.isEmpty()) {
                movie.setImagePath(IMAGE_DB_URL + imagePath);
                movie.setOverview(movieJson.getString(OVERVIEW));
                movie.setRating(movieJson.getString(RATING));
                movie.setReleaseDate(movieJson.getString(RELEASE_DATE));
                movie.setTitle(movieJson.getString(TITLE));

                movieList.add(movie);
                Log.v(TAG, "Movie created " + movie);
            }

        }

        Log.v(TAG, "Movie List Size " + movieList.size());
        return movieList;
    }

}
