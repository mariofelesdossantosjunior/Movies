package com.mario.movies.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mario.movies.R;
import com.mario.movies.model.entity.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mario on 10/03/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> movies;
    private Context mContext;

    public MoviesAdapter(Context mContext,List<Movie> movies) {
        this.movies = movies;
        this.mContext = mContext;
    }

    public void updateList(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Movie movie = movies.get(position);

        Picasso
                .with(mContext)
                .load(movie.getmPoster())
                .into(holder.itemMoviePoster);

        holder.itemMovieTitle.setText(movie.getmTitle());
        holder.itemMovieYear.setText(movie.getmYear());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_movie_poster)
        ImageView itemMoviePoster;
        @BindView(R.id.item_movie_title)
        TextView itemMovieTitle;
        @BindView(R.id.item_movie_year)
        TextView itemMovieYear;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}


