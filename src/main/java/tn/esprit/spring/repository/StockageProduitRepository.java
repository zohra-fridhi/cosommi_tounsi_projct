package tn.esprit.spring.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import tn.esprit.spring.entities.StockageProduit;






//@RepositoryRestResource permet d'exposé le web  service 
@RepositoryRestResource

public interface StockageProduitRepository extends JpaRepository<StockageProduit, Long> {
	
	// http://localhost:8081/produits/stockageProduits/search/byQuantity?m1=15&m2=2000
	@RestResource(path="/byQuantity")
	public List<StockageProduit> findByQuantityProduitBetween(@Param("m1") int q1 ,@Param("m2") int q2);
	
	// http://localhost:8081/produits/stockageProduits/search/byLieu?m1=A
	@RestResource(path="/byLieu")
	public List<StockageProduit> findByLieuStockageContains(@Param("m1") String  lieu );
}
