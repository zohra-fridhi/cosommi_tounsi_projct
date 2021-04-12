package tn.esprit.spring.produits.service;



import java.util.List;

import tn.esprit.spring.produits.entities.Facture;




public interface FactureService  {
	
	Facture saveFacture(Facture f);
	void deleteFactureById(Long id);
	Facture updateFacture(Facture f);
	List<Facture> getAllFactures();
	Facture getFacture(Long id);

	
}