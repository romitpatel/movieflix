package io.egen.api_module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api_module.entity.Movie;
import io.egen.api_module.entity.MovieRating;
import io.egen.api_module.service.MovieService;

@RestController
@RequestMapping(value="/movie")
public class MovieRatingController {

	@Autowired
	private MovieService service;

	// POST RATING

	@RequestMapping(method = RequestMethod.POST, value = "/postRating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieRating postRatingOnMovie(@RequestBody MovieRating rating) {
		return service.postRatingOnMovie(rating);
	}

	// GET AVERAGE RATING

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/getRating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getRatingOnMovie(@PathVariable("id") String mID) {
		return service.getRatingOnMovie(mID);
	}

	// TOP RATED

	@RequestMapping(method = RequestMethod.GET, value = "/top={type}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> getTopRatedMovie(@PathVariable("type") String type) {
		return service.getTopRatedMovie(type);
	}
		
}
