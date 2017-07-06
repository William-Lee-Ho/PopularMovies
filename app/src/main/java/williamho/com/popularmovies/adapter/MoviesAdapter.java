package williamho.com.popularmovies.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import williamho.com.popularmovies.R;
import williamho.com.popularmovies.activity.MovieDetailActivity;
import williamho.com.popularmovies.model.Movie;
import com.squareup.picasso.Picasso;

/**
 * Created by williamho on 26/06/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private LayoutInflater inflater;
    private Context context;

    public MoviesAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    //A view holder inner class where we get reference to the views in the layout using their ID

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;

        public MovieViewHolder(View v) {
            super(v);
            movieImage = (ImageView) v.findViewById(R.id.movie_image);
        }
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = inflater.inflate(R.layout.row_movie, parent, false);
        final MovieViewHolder viewHolder = new MovieViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movies.get(position));
                context.startActivity(intent);
            }
        });
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        Movie movie = movies.get(position);
        Picasso.with(context)
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .error(R.color.colorAccent)
                .into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        return (movies == null) ? 0 : movies.size();
    }

    public void setMovieList(List<Movie> movieList) {
        this.movies = new ArrayList<>();
        this.movies.addAll(movieList);
        notifyDataSetChanged();
    }
}