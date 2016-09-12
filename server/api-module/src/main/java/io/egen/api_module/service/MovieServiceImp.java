package io.egen.api_module.service;

import io.egen.api_module.entity.Movie;
import io.egen.api_module.entity.MovieDetails;
import io.egen.api_module.entity.MovieRating;
import io.egen.api_module.entity.UserComments;
import io.egen.api_module.exception.EntityAlreadyExistException;
import io.egen.api_module.exception.EntityNotFoundException;
import io.egen.api_module.exception.MissingRatingDetailsException;
import io.egen.api_module.repository.MovieRepository;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieServiceImp implements MovieService{

	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null)
			return null;
		return existing;
	}

	@Override
	public Movie create(Movie movie) {
		Movie existing = repository.findOne(movie.getImdbID());
		if (existing != null)
			throw new EntityAlreadyExistException("Title with ID: "
					+ movie.getImdbID() + " already exists");
		return repository.create(movie);
	}

	@Override
	public Movie update(String id, Movie movie) {
		Movie existing = repository.findOne(id);
		if (existing == null)
			throw new EntityNotFoundException("Title doesn't exist");
		return repository.update(movie);
	}

	@Override
	public void remove(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null)
			throw new EntityNotFoundException("No title with ID- " + id
					+ " found in the detabase");
		repository.delete(existing);

	}

	@Override
	public List<Movie> searchByGenre(String genre) {
		return repository.searchByGenre(genre);
	}

	@Override
	public List<Movie> searchByYear(int year) {
		return repository.searchByYear(year);
	}

	@Override
	public List<Movie> searchByType(String type) {
		return repository.searchByType(type);
	}

	@Override
	public String viewOnImdb(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null)
			throw new EntityNotFoundException("No title with ID- " + id
					+ "found");
		return "Movie: " + existing.getTitle() + "\nhttp://www.imdb.com/title/"
				+ id + "/";
	}

	@Override
	public List<Movie> search(String keyword) {
		List<Movie> existing = repository.search(keyword);
		if (existing == null)
			throw new EntityNotFoundException("No title with keyword- "
					+ keyword + "found");
		return existing;
	}

	@Override
	public MovieDetails getMovieDetails(String id) {
		MovieDetails existing = repository.getMovieDetails(id);
		if (existing == null)
			throw new EntityNotFoundException("No title with ID- " + id
					+ "found");
		return existing;
	}

	@Override
	public List<Movie> sortMovies(String string) {
		System.out.println("String in Service class is: " + string);
		return repository.sortMovies(string);
	}

	@Override
	public UserComments postCommentOnMovie(UserComments comment) {
		Movie existing = repository.findOne(comment.getImdbID());
		if (existing == null)
			throw new EntityNotFoundException("No title with ID- "
					+ comment.getImdbID() + "found");
		return repository.postCommentOnMovie(comment);
	}

	@Override
	public List<UserComments> getCommentOnMovie(String mID) {
		Movie existing = repository.findOne(mID);
		if (existing == null) {
			String error = "No title with ID: " + mID + " found";
			throw new EntityNotFoundException(error);
		}
		return repository.getCommentOnMovie(mID);
	}

	@Override
	public MovieRating postRatingOnMovie(MovieRating rating) {
		Movie existing = repository.findOne(rating.getImdbID());
		if (existing == null) {
			String error = "No title with ID: " + rating.getImdbID() + " found";
			throw new EntityNotFoundException(error);
		}
		if (rating.getRating() == null)
			throw new MissingRatingDetailsException(
					"Rating cannot be null and must be between 1 and 5");

		Double rate = Double.parseDouble(rating.getRating());
		System.out.println("User rating is: " + rate);
		if (rate < 1.0 || rate > 5.0)
			throw new MissingRatingDetailsException(
					"Rating cannot be null and must be between 1 and 5");
		return repository.postRatingOnMovie(rating);
	}

	@Override
	public String getRatingOnMovie(String mID) {
		Movie existing = repository.findOne(mID);
		if (existing == null) {
			String error = "No title with ID: " + mID + " found";
			throw new EntityNotFoundException(error);
		}
		Double rating = repository.getRatingOnMovie(mID);

		DecimalFormat two = new DecimalFormat("#0.00");
		String finalRating = "Average User Rating of " + existing.getTitle()
				+ ": " + two.format(rating) + "/5";
		return finalRating;
	}

	@Override
	public List<Movie> getTopRatedMovie(String type) {
		return repository.getTopMovies(type);
	}
	
	
}