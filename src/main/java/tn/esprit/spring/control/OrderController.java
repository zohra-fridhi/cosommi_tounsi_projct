package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Order;

import tn.esprit.spring.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired(required = true)
	IOrderService orderService;
	@PostMapping("/add")
	public Order addOrder (@RequestBody Order order) {
		return orderService.addOrder(order);
	}
	@GetMapping("/get")
	public List<Order> getAllOrders(){
		return orderService.getAll();
	}
	
	}
	


