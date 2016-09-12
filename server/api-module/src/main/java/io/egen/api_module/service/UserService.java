package io.egen.api_module.service;

import io.egen.api_module.entity.User;

import java.util.List;

public interface UserService {

	public List<User> findAll();

	public User findOne(String userId);

    public	User create(User user);

	public User update(String userId, User user);
	
	public void remove(String userId);

}
