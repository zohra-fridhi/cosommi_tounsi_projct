package tn.esprit.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>  {
	
      List<Product> findAllByNameContainingAndTypeContaining(String name,String type);
      @Query(value = "SELECT * FROM product WHERE barCode LIKE ?1%", nativeQuery = true)
  	  List<Product> findProduitByBarcode(String barCode);
      @Query(value ="SELECT * FROM product ORDER by price ASC LIMIT 3", nativeQuery = true)
      List<Product> getProductsOrderByPriceAscendent();
      
	
      
      
}
