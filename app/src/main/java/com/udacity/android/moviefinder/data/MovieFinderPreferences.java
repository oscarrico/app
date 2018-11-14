package com.udacity.android.moviefinder.data;

import android.content.Context;

public class MovieFinderPreferences {

    private static final String LANGUAGE_PARAM = "en-US";
    // TODO Add the API KEY
    private static final String API_KEY = "API_KEY_VALUE";
    private static final String POPULAR_DB_API_URL = "popular";
    private static final String TOP_RATED_DB_API_URL = "top_rated";
    private static final String NOW_PLAYING_DB_API_URL = "now_playing";

    public static String getPreferredNowPlaying(Context context) {
        return getDefaultNowPlaying();
    }

    private static String getDefaultNowPlaying() {
        return NOW_PLAYING_DB_API_URL;
    }


    public static String getPreferredTopRated(Context context) {
        return getDefaultTopRated();
    }

    private static String getDefaultTopRated() {
        return TOP_RATED_DB_API_URL;
    }

    public static String getPreferredPopularApi(Context context) {
        return getDefaultPopularApi();
    }

    private static String getDefaultPopularApi() {
        return POPULAR_DB_API_URL;
    }

    public static String getPreferredLanguage(Context context) {
        return getDefaultLanguage();
    }

    private static String getDefaultLanguage() {
        return LANGUAGE_PARAM;
    }

    public static String getPreferredKey(Context context) {
        return getDefaultApiKey();
    }

    private static String getDefaultApiKey() {
        return API_KEY;
    }
}
