package io.egen.api_module.repository;

import io.egen.api_module.entity.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryImp implements UserRepository {
   
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<User> findAll() {
		TypedQuery<User> query =em.createNamedQuery("User.findAll",User.class);
		return query.getResultList();
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query =em.createNamedQuery("User.findByEmail",User.class);
		query.setParameter("pemail", email);
		List<User> userloyees = query.getResultList();
		if (userloyees.size()==1){
			return userloyees.get(0);
		}
		else{
			return null;
		}
		
	}

	@Override
	public User findOne(String userId) {
		return em.find(User.class, userId);
	}

	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public void delete(User existing) {
		em.remove(existing);
	}

}
