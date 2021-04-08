package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Category;
import tn.esprit.spring.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public Category save(Category c) {
		
		return categoryRepository.save(c);
	}

	@Override
	public Category update(Category c, int id) {
		Category c1 = findOne(id);
		c1.setWording(c.getWording());
		return categoryRepository.save(c1);
	}

	@Override
	public List<Category> findAll() {
		List<Category> list=new ArrayList<>();
		 categoryRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public void delete(int id) {
		
		 categoryRepository.deleteById(id);
		
	}

	@Override
	public Category findOne(int id) {
		Category c= categoryRepository.findById(id).get();
		return c;
	}

	@Override
	public String getWordingById(int id) {
		String wording = categoryRepository.findById(id).get().getWording();
		return wording;
	}

}
