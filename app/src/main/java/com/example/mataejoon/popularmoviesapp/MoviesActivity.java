package com.example.mataejoon.popularmoviesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class MoviesActivity extends AppCompatActivity {

    private ImageAdapter    mMoviesAdapter;
    private GridView        mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        fetchViews();
        fetchDatas();
        setupGridView();
    }

    private void fetchViews() {
        mGridView = (GridView)findViewById(R.id.movies_gridview);
    }

    private void fetchDatas() {
        MovieStore.getInstance();
    }

    private void setupGridView() {
        mGridView.setAdapter(getAdapter());

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Movie movie = getMovieAtGridViewPosition(position);
                navigateToDetailActivity(movie);
            }
        });
    }

    private Movie getMovieAtGridViewPosition(int position) {
        return MovieStore.getInstance().getMovieWithID(position);
    }

    private void navigateToDetailActivity(Movie movie) {
        Intent intent = new Intent(MoviesActivity.this, MovieActivity.class);
//        intent.putExtra((Parcelable) movie);
        startActivity(intent);
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
