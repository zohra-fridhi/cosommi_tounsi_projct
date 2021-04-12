package tn.esprit.spring.service;




import java.util.List;


import tn.esprit.spring.entities.StockageProduit;

public interface StockageProduitService {
	StockageProduit saveProduit(StockageProduit p) throws Exception;
	void deleteProduitById(Long id);
	StockageProduit updateProduit(StockageProduit p);
	List<StockageProduit> getAllProduits();
	StockageProduit getProduit(Long id);
	int	findBylieuStockage(String lieuStockage);
     Long countProduct();
     
	
	
}
