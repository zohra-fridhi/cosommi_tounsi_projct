package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.Entity.OrderDelivery;

@Repository
public interface OrderDeliveryRepository extends CrudRepository <OrderDelivery, Integer> {
	@Modifying
	@Transactional
	@Query(value="DELETE FROM OrderDelivery")
	void deleteAllOrderDelivery(); 
}
