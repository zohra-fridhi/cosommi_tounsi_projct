package tn.esprit.spring.produits.service;




import java.util.List;


import tn.esprit.spring.produits.entities.StockageProduit;

public interface StockageProduitService {
	StockageProduit saveProduit(StockageProduit p);
	void deleteProduitById(Long id);
	StockageProduit updateProduit(StockageProduit p);
	List<StockageProduit> getAllProduits();
	StockageProduit getProduit(Long id);


	
	
}
