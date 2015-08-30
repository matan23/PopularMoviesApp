package com.example.mataejoon.popularmoviesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


public class MoviesActivity extends AppCompatActivity {

    private ArrayAdapter<String>    mMoviesAdapter;
    private ListView                mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        fetchView();
        setupListView();
    }

    private void fetchView() {
        mListView = (ListView)findViewById(R.id.movies_listview);
    }

    private void setupListView() {
        mListView.setAdapter(getAdapter());
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

    private ArrayAdapter<String> getAdapter() {
        mMoviesAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                fetchDatas()
        );

        return mMoviesAdapter;
    }

    private String[] fetchDatas() {
        String [] datas = {
                "Jurasic Park",
                "Very Bad Trip",
                "Forest Gump",
                "Whatever :)"
        };

        return datas;
    }
}
