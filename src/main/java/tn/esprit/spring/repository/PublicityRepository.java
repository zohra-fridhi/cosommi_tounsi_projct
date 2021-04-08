package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.entities.User;

public interface PublicityRepository extends CrudRepository<Publicity, Integer> {
	@Query(value="SELECT u from Publicity u WHERE :age  BETWEEN u.startAgeCible AND u.endAgeCible")
    List<Publicity> findPublicityUser(@Param("age")int ageUser);
	@Query(value = "SELECT COUNT(*) FROM user WHERE sexe='HOMME' AND age BETWEEN ?1 AND ?2", nativeQuery = true)
	public int  CountUserHommeWithAgeBetwin(int startAgeCible,int endAgeCible);
	@Query(value = "SELECT COUNT(*) FROM user WHERE sexe='FEMME' AND age BETWEEN ?1 AND ?2", nativeQuery = true)
	public int  CountUserFemmeWithAgeBetwin(int startAgeCible,int endAgeCible);
	@Query(value = "SELECT COUNT(*) FROM user WHERE age BETWEEN ?1 AND ?2", nativeQuery = true)
	public int  CountUserWithAgeBetwin(int startAgeCible,int endAgeCible);
}
