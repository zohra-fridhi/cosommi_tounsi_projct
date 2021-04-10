package tn.esprit.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>  {
	
      List<Product> findAllByNameContainingAndTypeContaining(String name,String type);
      @Query(value ="SELECT * FROM product ORDER by price ASC LIMIT 3", nativeQuery = true)
      List<Product> getProductsOrderByPriceAscendent();
      @Query(value="select sum(t_order.quantity) from products_orders inner join t_order\r\n" + 
      		"on   t_order.id=products_orders.order_id \r\n" + 
      		"inner join product\r\n" + 
      		"on product.prod_id= products_orders.product_id\r\n" + 
      		"and  product.prod_id =:prodId" ,nativeQuery = true)
      int getQuantityOfProductId(@Param("prodId") int prodId);
	
         
}
