package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="T_ORDER")
public class Order implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String stateOrder;
	int quantity;
	@ManyToMany(mappedBy="orders", cascade = CascadeType.ALL)
	private Set<Product> products;
	
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStateOrder() {
		return stateOrder;
	}
	public void setStateOrder(String stateOrder) {
		this.stateOrder = stateOrder;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Order() {}
	public Order(int id, String stateOrder, int quantity, Set<Product> products) {
		super();
		this.id = id;
		this.stateOrder = stateOrder;
		this.quantity = quantity;
		this.products = products;
	}

	

}
