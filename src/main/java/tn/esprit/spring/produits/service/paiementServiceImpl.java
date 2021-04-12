package tn.esprit.spring.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.produits.entities.Paiement;
import tn.esprit.spring.produits.repos.PaiementRepository;

@Service
public class paiementServiceImpl implements PaiementService{

	@Autowired
	PaiementRepository paiementRepository ;
	
	@Override
	public Paiement savePaiement(Paiement pai) {
		
		return paiementRepository.save(pai);
	}

	@Override
	public void deletePaiementById(Long idPaiement) {
		
		paiementRepository.deleteById(idPaiement);
	}

	@Override
	public Paiement updatePaiement(Paiement pai) {
	
		return paiementRepository.save(pai);
	}

	@Override
	public List<Paiement> getAllPaiements() {
		
		return paiementRepository.findAll();
	}

	@Override
	public Paiement getPaiement(Long idPaiement) {
		
		return paiementRepository.findById(idPaiement).get(); 
	}

}
