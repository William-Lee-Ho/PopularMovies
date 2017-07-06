package williamho.com.popularmovies.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import williamho.com.popularmovies.R;
import williamho.com.popularmovies.model.Movie;


/**
 * Created by williamho on 29/06/2017.
 */

public class MovieDetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "movie";

    private Movie movie;
    ImageView backdrop;
    ImageView poster;
    TextView title;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        if (getIntent().hasExtra(EXTRA_MOVIE)) {
            movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        } else {
            throw new IllegalArgumentException("Detail activity must receive a movie parcelable");
        }

        backdrop = (ImageView) findViewById(R.id.backdrop);
        title = (TextView) findViewById(R.id.movie_title);
        description = (TextView) findViewById(R.id.movie_description);
        poster = (ImageView) findViewById(R.id.movie_poster);

        title.setText(movie.getTitle());
        description.setText(movie.getDescription());
        Picasso.with(this)
                .load(movie.getPoster())
                .into(poster);
        Picasso.with(this)
                .load(movie.getBackdrop())
                .into(backdrop);
    }
}