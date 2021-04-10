package tn.esprit.spring.service;

import java.util.List;



import tn.esprit.spring.entities.Product;


public interface IProductService {
	List<Product> retrieveProductByNameAndType(String name, String type);
	Product updateProduct(Product prod, int id);
	Product addProduct(Product prod);
	String deleteProduct(int id);
	Product getProductById(int id);
	void AffectProductToCategory(int prodId, int catId);
	List<String> findProductNameCategory(int catId);
	List<Product> orderProductByPrice();
	int getQuantityProduct(int prodId);
}
