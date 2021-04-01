package tn.esprit.spring.service;

import java.util.NoSuchElementException;

import tn.esprit.spring.entity.CategoriePublication;


public interface ICategoriePublicationService {

	CategoriePublication createOrUpdate(CategoriePublication categoriePublication);
	void delete(Long id);
	CategoriePublication getById(Long id) throws NoSuchElementException;
	

}
