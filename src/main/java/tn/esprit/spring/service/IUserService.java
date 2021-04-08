package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.User;

public interface IUserService {
   User addUser(User user);
   List<User> getUsers();
}
