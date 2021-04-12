package tn.esprit.spring.produits.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.produits.entities.Facture;

import tn.esprit.spring.produits.repos.FactureRepository;

@Service
public class FactureServiceImpl implements FactureService {
	
	
	@Autowired
	FactureRepository Factrepository ;

	@Override
	public Facture saveFacture(Facture f) {
		
		
	return  Factrepository.save( f);
	
	
	}

	@Override
	public void deleteFactureById(Long id) {
	
		Factrepository.deleteById(id);
		
	}

	@Override
	public Facture updateFacture(Facture f) {
	
		return Factrepository.save(f);
	}

	@Override
	public List<Facture> getAllFactures() {
		
		return Factrepository.findAll();
	}

	@Override
	public Facture getFacture(Long id) {
		
		return Factrepository.findById(id).get();
	}

	
}
