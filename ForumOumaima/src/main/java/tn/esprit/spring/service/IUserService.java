package tn.esprit.spring.service;

import java.util.NoSuchElementException;
import tn.esprit.spring.entity.User;

public interface IUserService {
	public User createOrUpdate(User user);
	public void delete(Long id);
	User getById (Long id) throws NoSuchElementException;
}
