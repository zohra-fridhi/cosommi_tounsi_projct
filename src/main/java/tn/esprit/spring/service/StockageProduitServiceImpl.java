package tn.esprit.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import tn.esprit.spring.entities.StockageProduit;
import tn.esprit.spring.repository.StockageProduitRepository;
import tn.esprit.spring.util.FiltreBadWords;


@Service
public class StockageProduitServiceImpl implements StockageProduitService{
	
	//pour faire l'injection de dépendance :@Autowired injecter une implémentation de l'interface <ProduitRepository>
	@Autowired
	StockageProduitRepository produitRepository;
	
	@Override
	public StockageProduit saveProduit(StockageProduit p) throws Exception {
	FiltreBadWords.loadConfigs();
	p.setNomProduit(FiltreBadWords.filterText(p.getNomProduit()));
	return produitRepository.save(p);
	}
	
	@Override
	public void deleteProduitById(Long id) {
			produitRepository.deleteById(id);
		
	}

	@Override
	public StockageProduit updateProduit(StockageProduit p) {
	//	List<String> badWords= FiltreBadWords.badWordsFound(p.getNomProduit());
	//	System.out.println(badWords);
	//	if (badWords != null)
	//		return null ;
		return produitRepository.save(p);
	}

	@Override
	public List<StockageProduit> getAllProduits() {
		
		return produitRepository.findAll();
	}
	

	@Override
	public StockageProduit getProduit(Long id) {
		return produitRepository.findById(id).get();
	}

	
	@Override
	public Long countProduct() {
		
		return produitRepository.count();
	}

	@Override
	public int findBylieuStockage(String lieuStockage) {
		
		List<StockageProduit>listProductBylieuStockage =  produitRepository.findByLieuStockageContains(lieuStockage);
		 int countProductBylieuStockage =  listProductBylieuStockage.size();
		return countProductBylieuStockage ;
	}
	
	
	
	
}