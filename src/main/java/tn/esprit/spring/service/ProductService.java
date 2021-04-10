package tn.esprit.spring.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Product> retrieveProductByNameAndType (String name,String type) {
		List<Product> products = new ArrayList<>();
		products =  productRepository.findAllByNameContainingAndTypeContaining(name, type);
		return products;
	}

	@Override
	public Product updateProduct(Product prod, int id) {
		Product p1=  productRepository.findById(id).get();
		p1.setBarCode(prod.getBarCode());
		p1.setDescription(prod.getDescription());
		p1.setName(prod.getName());
		p1.setPrice(prod.getPrice());
		p1.setType(prod.getType());
		return productRepository.save(p1);
	}

	@Override
	public Product addProduct(Product prod) {
		Product p=productRepository.save(prod);
		return p;
	}

	@Override
	public String deleteProduct(int id) {
		Product p=  productRepository.findById(id).get();
		productRepository.delete(p);
		return "produit deleted";
	}

	@Override
	public Product getProductById(int id) {

		return productRepository.findById(id).get();
	}

	@Override
	public void AffectProductToCategory(int prodId, int catId) {
		Product p= productRepository.findById(prodId).get();
		Category c=categoryRepository.findById(catId).get();
		p.setCategory(c);
		productRepository.save(p);
	}

	@Override
	public List<String> findProductNameCategory(int catId) {
		Category c=categoryRepository.findById(catId).get();
		List<String> prodName=new ArrayList<>();
		for(Product p:c.getProducts()) {
			prodName.add(p.getName());
		}
		return prodName;
	}

	@Override
	public List<Product> orderProductByPrice() {
		
		return productRepository.getProductsOrderByPriceAscendent();
	}

	@Override
	public int getQuantityProduct(int prodId) {
		
		return productRepository.getQuantityOfProductId(prodId);
	}

}
