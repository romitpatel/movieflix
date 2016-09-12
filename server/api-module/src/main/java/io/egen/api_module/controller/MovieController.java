package io.egen.api_module.controller;

import io.egen.api_module.entity.Movie;
import io.egen.api_module.service.MovieService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/movie",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {
	
	@Autowired
	private MovieService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Movie findOne(@PathVariable("id") String id) {
		return service.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie) {
		return service.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String id, @RequestBody Movie movie) {
		return service.update(id, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.remove(id);

	}
}
