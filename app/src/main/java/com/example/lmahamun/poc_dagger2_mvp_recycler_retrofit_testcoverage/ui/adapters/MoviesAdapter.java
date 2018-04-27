package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.adapters;

/**
 * Created by Laxmikant Mahamuni on 22-03-2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.R;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model.Movie;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.interfaces.OnRecyclerItemClickListener;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public MoviesAdapter(List<Movie> moviesList, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.moviesList = moviesList;
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getReleaseDate());
        holder.year.setText(movie.getAdult());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRecyclerItemClickListener.onItemClick(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
