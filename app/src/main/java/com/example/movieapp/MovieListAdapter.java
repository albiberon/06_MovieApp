package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieapp.Model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private String baseImageURL = "https://image.tmdb.org/t/p/w500";
    private List<Movie> movieList;
    private Context context;

    public MovieListAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.grid_cell, viewGroup, false);
        return new MovieListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        //Load image
        Picasso.get().load(new StringBuilder(baseImageURL + movieList.get(viewHolder.getAdapterPosition()).getPosterImage())
                .toString()).into(viewHolder.posterImage);
        viewHolder.movieNumber.setText(String.valueOf(viewHolder.getAdapterPosition() + 1));

        viewHolder.movieContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("posterImage", movieList.get(viewHolder.getAdapterPosition()).getPosterImage());
                intent.putExtra("backdropImage", movieList.get(viewHolder.getAdapterPosition()).getBackdropImage());
                intent.putExtra("releaseDate", movieList.get(viewHolder.getAdapterPosition()).getReleaseDate());
                intent.putExtra("rating", movieList.get(viewHolder.getAdapterPosition()).getRating());
                intent.putExtra("overview", movieList.get(viewHolder.getAdapterPosition()).getOverview());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void swapList (List<Movie> newList) {
        movieList = newList;
        if (newList != null) {
            this.notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView posterImage;
        private TextView movieNumber;
        private ConstraintLayout movieContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImage = itemView.findViewById(R.id.posterImage);
            movieNumber = itemView.findViewById(R.id.movieNumber);
            movieContainer = itemView.findViewById(R.id.movieContainer);
        }
    }
}
