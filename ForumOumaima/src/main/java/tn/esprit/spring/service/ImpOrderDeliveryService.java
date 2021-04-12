package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.OrderDelivery;

public interface ImpOrderDeliveryService {
	public List<OrderDelivery> getAllTheOrderDeliverys();

	public OrderDelivery getOrderDelivery(int id);

	public void saveOrderDelivery(OrderDelivery orderDelivery ,int userId);

	public void updateOrderDelivery(OrderDelivery orderDelivery);

	public void deleteOrderDelivery(int id);

	public void affectUserToOrder(int userId, int orderId);
	public void deliveryCost(int orderId) ;
}
