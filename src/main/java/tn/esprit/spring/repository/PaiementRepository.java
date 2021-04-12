package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.esprit.spring.entities.Paiement;



@RepositoryRestResource
public interface PaiementRepository extends JpaRepository<Paiement, Long> {

	// http://localhost:8081/produits/
	// @RestResource(path="/bytotale")
	
	//  public List<Paiement> findByTotaleBetween(@Param("m1") Double q1 , @Param("m2") double q2);
	
	
}
