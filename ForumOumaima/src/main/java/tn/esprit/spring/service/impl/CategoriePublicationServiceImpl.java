package tn.esprit.spring.service.impl;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.esprit.spring.entity.CategoriePublication;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.repository.ICategoriePublicationRepository;
import tn.esprit.spring.service.ICategoriePublicationService;

@AllArgsConstructor
@Service
public class CategoriePublicationServiceImpl implements ICategoriePublicationService{

	private final ICategoriePublicationRepository categoriePublicationRepository;
	@Override
	public CategoriePublication createOrUpdate(CategoriePublication categoriePublication) {
		if (categoriePublication.getId()!=null) 
		{
				getById(categoriePublication.getId());
		}
		return categoriePublicationRepository.save(categoriePublication);
	}

	@Override
	public void delete(Long id) {
		categoriePublicationRepository.deleteById(id);
		
	}

	@Override
	public CategoriePublication getById(Long id) throws NoSuchElementException {
		Optional<CategoriePublication> categoriePublication = categoriePublicationRepository.findById(id);
		if (categoriePublication.isPresent()) return categoriePublication.get();
		throw new NoSuchElementException();
	}

	public List<CategoriePublication> getAllCategorie(){
		return categoriePublicationRepository.findAll();
	}
	 
	
	
}
