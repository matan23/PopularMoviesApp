package com.example.mataejoon.popularmoviesapp;

/**
 * Created by mataejoon on 8/30/15.
 */
public class MovieStore {
    private static MovieStore mInstance = new MovieStore();

    private MovieStore(){}

    public static MovieStore getInstance() {
        return mInstance;
    }

    public Movie getMovieWithID(int id) {
        try {
            return mMovies[id];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

    }

    public int getThumbnailForMovieWithID(int id) {
        Movie movie = getMovieWithID(id);
        return movie.getThumbnail();
    }

    private Movie[] mMovies = {
            new Movie(R.drawable.missionimpossible),
            new Movie(R.drawable.southpaw),
            new Movie(R.drawable.theinterns),
            new Movie(R.drawable.verybadtrip)
    };
}
