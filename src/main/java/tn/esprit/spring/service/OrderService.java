package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Order;
import tn.esprit.spring.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {
	@Autowired
	OrderRepository orderRep;

	@Override
	public Order addOrder(Order order) {
		
		return orderRep.save(order);
	}

	@Override
	public List<Order> getAll() {
		
		return (List<Order>) orderRep.findAll();
	}

}
