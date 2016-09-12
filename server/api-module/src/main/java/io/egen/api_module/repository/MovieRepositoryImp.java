package io.egen.api_module.repository;

import io.egen.api_module.entity.Movie;
import io.egen.api_module.entity.MovieDetails;
import io.egen.api_module.entity.MovieRating;
import io.egen.api_module.entity.UserComments;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


@Repository
public class MovieRepositoryImp implements MovieRepository{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		MovieDetails details = createMovieDetailsObject(movie);
		em.persist(details);
		em.flush();
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		MovieDetails details = createMovieDetailsObject(movie);
		em.merge(details);
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		TypedQuery<MovieDetails> query = em.createQuery("Movie.findByID",MovieDetails.class);
		MovieDetails movieDetails = query.getSingleResult();
		em.remove(movieDetails);
		em.remove(movie);
	}

	public MovieDetails createMovieDetailsObject(Movie movie) {
		MovieDetails details = new MovieDetails();
		details.setImdbID(movie.getImdbID());
		details.setActors(movie.getActors());
		details.setDirector(movie.getDirector());
		details.setImdbRating(movie.getImdbRating());
		details.setPlot(movie.getPlot());
		return details;
	}

	@Override
	public List<Movie> search(String keyword) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.searchInMovies",Movie.class);
		query.setParameter("searchText", "%" + keyword + "%");
		List<Movie> movies = query.getResultList();
		if (movies != null)
			return movies;
		return null;
	}

	@Override
	public MovieDetails getMovieDetails(String id) {
		return em.find(MovieDetails.class, id);
	}

	@Override
	public List<Movie> getTopMovies(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.topMovies",Movie.class);
		query.setParameter("pType", type);
		query.setMaxResults(50);
		return query.getResultList();
	}

	@Override
	public List<Movie> searchByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.searchByType",Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

	@Override
	public List<Movie> searchByYear(int year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.searchByYear",Movie.class);
		query.setParameter("pYear", year);
		return query.getResultList();
	}

	@Override
	public List<Movie> searchByGenre(String genre) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.searchByGenre",Movie.class);
		query.setParameter("pGenre", "%" + genre + "%");
		return query.getResultList();
	}

	@Override
	public List<Movie> sortMovies(String sort) {
		System.out.println("String is: " + sort);
		if (sort == "votes") {
			TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByVotes",Movie.class);
			return query.getResultList();
		} else if (sort == "year") {
			TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByYear",Movie.class);
			return query.getResultList();
		} else if (sort == "rating") {
			TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByRating", Movie.class);
			return query.getResultList();
		}
		return null;
	}

	@Override
	public UserComments postCommentOnMovie(UserComments comment) {
		comment.setUserName("User authentication yet to be implemented");
		em.persist(comment);
		return comment;
	}

	@Override
	public List<UserComments> getCommentOnMovie(String mID) {
		TypedQuery<UserComments> query = em.createNamedQuery("UserComments.findByMovieID", UserComments.class);
		query.setParameter("pID", mID);
		List<UserComments> comments = query.getResultList();
		if (comments != null)
			return comments;
		return null;
	}

	@Override
	public MovieRating postRatingOnMovie(MovieRating rating) {
		rating.setRatedBy("User authentication yet to be implemented");
		em.persist(rating);
		return rating;
	}

	@Override
	public Double getRatingOnMovie(String mID) {
		TypedQuery<Double> query = em.createNamedQuery("MovieRating.findAvgRatingByMovieID", Double.class);
		query.setParameter("pID", mID);
		Double rating = query.getSingleResult();
		if (rating != null)
			return rating;
		return null;
	}
	

}
