package tn.esprit.spring.service;




import java.util.List;


import tn.esprit.spring.entities.StockageProduit;

public interface StockageProduitService {
	StockageProduit saveProduit(StockageProduit p);
	void deleteProduitById(Long id);
	StockageProduit updateProduit(StockageProduit p);
	List<StockageProduit> getAllProduits();
	StockageProduit getProduit(Long id);


	
	
}
