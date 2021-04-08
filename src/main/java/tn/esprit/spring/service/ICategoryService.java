package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Category;

public interface ICategoryService {
	public Category save(Category c);
	public Category update(Category c,int id);
	public List<Category> findAll();
	public void delete(int id);
	public String getWordingById(int id);
	public Category findOne(int id);

}
