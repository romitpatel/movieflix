package io.egen.api_module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api_module.entity.MovieDetails;
import io.egen.api_module.entity.Movie;
import io.egen.api_module.service.MovieService;

@RestController
@RequestMapping(value="/movie")
public class MovieInfoController {

	@Autowired
	private MovieService service;

	
	// GO TO IMDB SITE
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}/viewOnImdb")
	public String viewOnImdb(@PathVariable("id") String id) {
		return service.viewOnImdb(id);
	}

	// GET DETAILS ABOUT MOVIE
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}/getMovieDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieDetails getMovieDetails(@PathVariable("id") String id) {
		return service.getMovieDetails(id);
	}

	// SEARCH MOVIE
	
	@RequestMapping(method = RequestMethod.GET, value = "/search={search}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> search(@PathVariable("search") String keyword) {
		return service.search(keyword);
	}

}