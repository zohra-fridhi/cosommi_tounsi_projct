package tn.esprit.spring.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "DeleveryMan")
public class DeliveryMan extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String vheicule;
	private int point;
	private boolean disponibility;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryMan")
	private List<OrderDelivery> orderDeliverys;

	public String getVheicule() {
		return vheicule;
	}

	public void setVheicule(String vheicule) {
		this.vheicule = vheicule;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean isDisponibility() {
		return disponibility;
	}

	public void setDisponibility(boolean disponibility) {
		this.disponibility = disponibility;
	}

	public DeliveryMan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<OrderDelivery> getOrderDeliverys() {
		return orderDeliverys;
	}

	public void setOrderDeliverys(List<OrderDelivery> orderDeliverys) {
		this.orderDeliverys = orderDeliverys;
	}


		


}
