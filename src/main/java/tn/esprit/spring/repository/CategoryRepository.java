package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.Product;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
	public Category findCategorieBywording(String wording);

	public void save(Product p);

}
