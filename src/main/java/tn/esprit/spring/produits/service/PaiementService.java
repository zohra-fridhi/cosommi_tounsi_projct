package tn.esprit.spring.produits.service;

import java.util.List;

import tn.esprit.spring.produits.entities.Paiement;





public interface PaiementService {
	
	Paiement savePaiement(Paiement pai);
	void deletePaiementById(Long  idPaiement);
	Paiement updatePaiement(Paiement pai);
	List<Paiement> getAllPaiements();
	Paiement getPaiement(Long idPaiement);

}
