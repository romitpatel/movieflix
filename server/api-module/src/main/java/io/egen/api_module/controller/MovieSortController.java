package io.egen.api_module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api_module.entity.Movie;
import io.egen.api_module.service.MovieService;

@RestController
@ResponseBody
public class MovieSortController {
	
	@Autowired
	private MovieService service;
	
	// SORT BY IMDBVOTES
	
	@RequestMapping(method = RequestMethod.GET, value = "/sortbyvotes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortMoviesByImdbVotes() {
		System.out.println("Request to sort by votes");
		return service.sortMovies("votes");
	}

	// SORT BY YEAR
	
	@RequestMapping(method = RequestMethod.GET, value = "/sortbyyear", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortMoviesByYear() {
		System.out.println("Request to sort by year");
		return service.sortMovies("year");
	}

	// SORT BY IMDBRATINGS
	
	@RequestMapping(method = RequestMethod.GET, value = "/sortbyrating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortMoviesByImdbRating() {
		System.out.println("Request to sort by ImdbRating");
		return service.sortMovies("rating");
	}
}
