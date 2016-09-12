package io.egen.api_module.controller;

import java.util.List;

import io.egen.api_module.entity.Movie;
import io.egen.api_module.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/movie",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieSearchController {
	
	@Autowired
	private MovieService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/search/genre={genre}")
	public List<Movie> searchByGenre(@PathVariable("genre") String genre) {
		return service.searchByGenre(genre);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/search/type={type}")
	public List<Movie> searchByType(@PathVariable("type") String type) {
		return service.searchByType(type);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/search/year={year}")
	public List<Movie> searchByYear(@PathVariable("year") int year) {
		return service.searchByYear(year);
	}

}

