package io.egen.api_module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api_module.entity.UserComments;
import io.egen.api_module.service.MovieService;

@RestController
@RequestMapping(value="/movie")
public class UserCommentsController {
	@Autowired
	private MovieService service;
	
	
	// POST COMMENT
	
	@RequestMapping(method = RequestMethod.POST, value = "/postComment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserComments postCommentOnMovie(@RequestBody UserComments comment) {
		return service.postCommentOnMovie(comment);
	}

	// GET COMMENT
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}/viewComments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserComments> getCommentOnMovie(
			@PathVariable("id") String mID) {
		return service.getCommentOnMovie(mID);
	}

}
