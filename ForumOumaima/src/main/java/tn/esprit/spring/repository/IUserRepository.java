package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

	Optional<User> findByLogin(String username);
	

}
