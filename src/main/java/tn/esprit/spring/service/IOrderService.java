package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Order;

public interface IOrderService {
	Order addOrder(Order order);
	List<Order> getAll();

}
