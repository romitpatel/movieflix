package io.egen.api_module.repository;

import io.egen.api_module.entity.User;

import java.util.List;

public interface UserRepository {

	

	public List<User> findAll();

	public User findByEmail(String email);

	public User findOne(String userId);

	public User create(User user);

	public User update(User user);

	public void delete(User existing);
	

}
