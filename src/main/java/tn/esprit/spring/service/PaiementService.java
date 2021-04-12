package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Paiement;





public interface PaiementService {
	
	Paiement savePaiement(Paiement pai);
	void deletePaiementById(Long  idPaiement);
	Paiement updatePaiement(Paiement pai);
	List<Paiement> getAllPaiements();
	Paiement getPaiement(Long idPaiement);

}
