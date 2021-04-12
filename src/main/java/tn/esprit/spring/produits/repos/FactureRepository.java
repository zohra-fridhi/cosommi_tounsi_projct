package tn.esprit.spring.produits.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import tn.esprit.spring.produits.entities.Facture;



@RepositoryRestResource
public interface FactureRepository extends JpaRepository<Facture, Long>{

	// http://localhost:8081/produits/factures/search/byname?m1=aa
	@RestResource(path="/byname")
	public List<Facture> findBynomclientContains(@Param("m1") String  q1 );
	
	
	//@RestResource(path="/bynomclient")
	//public List<Facture>  findBycalculmontantBetween(@Param("m1") )
}
