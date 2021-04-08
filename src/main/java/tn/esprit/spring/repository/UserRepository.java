package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	@Query(value="SELECT u from User u WHERE age BETWEEN ?1 AND ?2")
     List<User> getUserAgeBetween(int startAge, int endAge);
	

}
