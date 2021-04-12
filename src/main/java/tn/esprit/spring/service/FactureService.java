package tn.esprit.spring.service;



import java.util.List;

import tn.esprit.spring.entities.Facture;




public interface FactureService  {
	
	Facture saveFacture(Facture f);
	void deleteFactureById(Long id);
	Facture updateFacture(Facture f);
	List<Facture> getAllFactures();
	Facture getFacture(Long id);

	
}