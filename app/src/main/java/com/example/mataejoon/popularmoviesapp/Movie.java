package com.example.mataejoon.popularmoviesapp;

/**
 * Created by mataejoon on 8/30/15.
 */
public class Movie {
    int mDrawableId = -1;

    public Movie(int drawableId) {
        mDrawableId = drawableId;
    }

    public int getThumbnail() {
        return mDrawableId;
    }
}
