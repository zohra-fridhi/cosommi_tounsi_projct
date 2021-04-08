package tn.esprit.spring.service;

import java.util.NoSuchElementException;
import java.util.Set;

import tn.esprit.spring.entity.History;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.CategoriePublication;


public interface IHistoryService {
	public History createOrUpdate(History history);
	public void delete(Long id);
	History getById (Long id) throws NoSuchElementException;
	Set<CategoriePublication> getUserFavCategories(User user);
}
