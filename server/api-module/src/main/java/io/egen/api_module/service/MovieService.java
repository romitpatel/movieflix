package io.egen.api_module.service;

import io.egen.api_module.entity.Movie;
import io.egen.api_module.entity.MovieDetails;
import io.egen.api_module.entity.MovieRating;
import io.egen.api_module.entity.UserComments;

import java.util.List;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie create(Movie movie);

	public Movie update(String id, Movie movie);

	public void remove(String id);

	public List<Movie> searchByGenre(String genre);

	public List<Movie> searchByYear(int year);

	public String viewOnImdb(String id);

	public List<Movie> search(String keyword);

	public MovieDetails getMovieDetails(String id);

	public List<Movie> sortMovies(String string);

	public UserComments postCommentOnMovie(UserComments comment);

	public List<UserComments> getCommentOnMovie(String mID);

	public MovieRating postRatingOnMovie(MovieRating rating);

	public String getRatingOnMovie(String mID);

	public List<Movie> getTopRatedMovie(String type);

	public List<Movie> searchByType(String type);

	

}
