package com.app.moviedbt;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CustomViewHolder> {

    private List<MovieModel> movieList;
    private Context context;

    public MovieAdapter(List<MovieModel> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View view = inflater.inflate(R.layout.movie_list_page , parent, false);
       return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Glide.with(context).load(movieList.get(position).getPoster()).into(holder.imageView);
        holder.title.setText(movieList.get(position).getTitle());
        holder.runtime.setText(movieList.get(position).getRuntime());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView runtime;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
             imageView = itemView.findViewById(R.id.image);
             title = itemView.findViewById(R.id.title);
             runtime = itemView.findViewById(R.id.runTime);
        }
    }
}
