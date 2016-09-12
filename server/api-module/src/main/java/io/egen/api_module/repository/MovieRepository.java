package io.egen.api_module.repository;

import java.util.List;

import io.egen.api_module.entity.UserComments;
import io.egen.api_module.entity.MovieDetails;
import io.egen.api_module.entity.Movie;
import io.egen.api_module.entity.MovieRating;

public interface MovieRepository {
	
	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie movie);

	public List<Movie> search(String keyword);

	public MovieDetails getMovieDetails(String id);

	public List<Movie> getTopMovies(String type);

	public List<Movie> searchByType(String type);

	public List<Movie> searchByYear(int year);

	public List<Movie> searchByGenre(String genre);

	public List<Movie> sortMovies(String string);

	public UserComments postCommentOnMovie(UserComments comment);

	public List<UserComments> getCommentOnMovie(String mID);

	public MovieRating postRatingOnMovie(MovieRating rating);

	public Double getRatingOnMovie(String mID);
}