package williamho.com.popularmovies.rest;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Call;
import williamho.com.popularmovies.model.MovieResponse;

/**
 * Created by williamho on 26/06/2017.
 */

public interface MovieApiService {

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);
}