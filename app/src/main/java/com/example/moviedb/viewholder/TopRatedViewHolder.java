package com.example.moviedb.viewholder;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.moviedb.R;

public class TopRatedViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageview;

    public TopRatedViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageview = itemView.findViewById(R.id.image_top_rated);
    }
}
