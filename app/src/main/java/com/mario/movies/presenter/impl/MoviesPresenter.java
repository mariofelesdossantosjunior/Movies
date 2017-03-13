package com.mario.movies.presenter.impl;

import com.mario.movies.model.remote.impl.MoviesAPI;
import com.mario.movies.presenter.IMoviesPresenter;
import com.mario.movies.view.IMainActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mario on 12/03/17.
 */

public class MoviesPresenter implements IMoviesPresenter{
    private MoviesAPI mMoviesAPI;
    private IMainActivity mIMainActivity;

    public MoviesPresenter(IMainActivity mIMainActivity) {
        this.mMoviesAPI = MoviesAPI.getInstance();
        this.mIMainActivity = mIMainActivity;
    }


    @Override
    public void loadMovies() {
        mMoviesAPI
                .getAPI()
                .search("a")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mIMainActivity::showMoviesOnIU);

    }



    @Override
    public void searchMovies(String q) {
        mMoviesAPI
                .getAPI()
                .search(q)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mIMainActivity::showMoviesOnIU);
    }
}
