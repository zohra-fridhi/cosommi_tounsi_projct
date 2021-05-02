package tn.esprit.spring.service;

import java.util.List;
import java.util.NoSuchElementException;

import tn.esprit.spring.entity.CategoriePublication;
import tn.esprit.spring.entity.User;



public interface ICategoriePublicationService {

	CategoriePublication createOrUpdate(CategoriePublication categoriePublication);
	void delete(Long id);
	CategoriePublication getById(Long id) throws NoSuchElementException;
	List<CategoriePublication> getAllCategorie();
	

}
