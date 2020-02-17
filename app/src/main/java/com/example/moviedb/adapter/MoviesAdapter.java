package com.example.moviedb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.moviedb.R;
import com.example.moviedb.model.TopRated;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.TopRatedViewHolder> implements Filterable {

    private List<TopRated> movieList;
    private final static int TOP_RATED = 1;
    private Context context;

    public MoviesAdapter(List<TopRated> list, Context context) {
        this.movieList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MoviesAdapter.TopRatedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_movies,parent,false);
      return new TopRatedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.TopRatedViewHolder viewHolder, int position) {
        Picasso.get().load(movieList.get(position).getPosterPath()).into(viewHolder.toprated);
    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public class TopRatedViewHolder extends RecyclerView.ViewHolder {

        private ImageView toprated;

        public TopRatedViewHolder(@NonNull View itemView) {
            super(itemView);
            this.toprated = itemView.findViewById(R.id.image_top_rated);
        }
    }

}