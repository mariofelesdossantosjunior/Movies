package com.mario.movies.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.mario.movies.R;
import com.mario.movies.model.entity.Movie;
import com.mario.movies.model.entity.MovieSearchResult;
import com.mario.movies.presenter.impl.MoviesPresenter;
import com.mario.movies.view.IMainActivity;
import com.mario.movies.view.adapter.MoviesAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Mario Feles dos Santos Junior
 * @email <mario_feles@live.com/>
 * @project Movies
 * @since 10/03/17 - 14:12
 */
public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, BottomNavigationView.OnNavigationItemSelectedListener, IMainActivity {

    @BindView(R.id.rvMovies) RecyclerView rvMovies;
    @BindView(R.id.navigation) BottomNavigationView navigation;

    private MoviesPresenter presenter;
    private MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_activity);
        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(this);

        presenter = new MoviesPresenter(this);
        presenter.loadMovies();

    }

    private void updateTable(List<Movie> movies) {
        adapter = new MoviesAdapter(MainActivity.this,movies);
        rvMovies.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        rvMovies.setAdapter(adapter);
    }


    @Override
    public void showMoviesOnIU(MovieSearchResult movieSearchResult) {
        updateTable(movieSearchResult.getMovies());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        presenter.searchMovies(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                return true;
            case R.id.navigation_dashboard:
                return true;
            case R.id.navigation_notifications:
                return true;
        }
        return false;
    }

}
