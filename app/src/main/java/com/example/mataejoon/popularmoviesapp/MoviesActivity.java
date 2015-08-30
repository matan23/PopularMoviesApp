package com.example.mataejoon.popularmoviesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;


public class MoviesActivity extends AppCompatActivity {

    private ImageAdapter    mMoviesAdapter;
    private GridView        mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        fetchViews();
        setupGridView();
    }

    private void fetchViews() {
        mGridView = (GridView)findViewById(R.id.movies_gridview);
    }

    private void setupGridView() {
        mGridView.setAdapter(getAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movies, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private ImageAdapter getAdapter() {
        mMoviesAdapter = new ImageAdapter(this);
        return mMoviesAdapter;
    }
}
