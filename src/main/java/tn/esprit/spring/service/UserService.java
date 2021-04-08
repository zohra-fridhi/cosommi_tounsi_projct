package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRep;

	@Override
	public User addUser(User user) {
		
		return userRep.save(user);
	}

	@Override
	public List<User> getUsers() {
		
		return (List<User>) userRep.findAll();
	}

}
