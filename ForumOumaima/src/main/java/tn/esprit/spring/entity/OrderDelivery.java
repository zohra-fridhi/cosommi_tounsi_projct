package tn.esprit.spring.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "OrderDelivery_table")
public class OrderDelivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String orderState;
	private String paymentMode;
	private LocalDateTime deliveryDate;
	private double deliveryprice;
	private String DeliveryManName;
	private String CoustomerName;
	private String CoustomerPhone;
	private String CoustomerAdress;
	@ManyToOne
   // @JsonBackReference
	private DeliveryMan deliveryMan;
	@ManyToOne
   // @JsonBackReference

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public OrderDelivery() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	public double getDeliveryprice() {
		return deliveryprice;
	}

	public void setDeliveryprice(double deliveryprice) {
		this.deliveryprice = deliveryprice;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryManName() {
		return DeliveryManName;
	}

	public void setDeliveryManName(String deliveryManName) {
		DeliveryManName = deliveryManName;
	}

	public String getCoustomerName() {
		return CoustomerName;
	}

	public void setCoustomerName(String coustomerName) {
		CoustomerName = coustomerName;
	}

	public String getCoustomerAdress() {
		return CoustomerAdress;
	}

	public void setCoustomerAdress(String coustomerAdress) {
		CoustomerAdress = coustomerAdress;
	}

	public String getCoustomerPhone() {
		return CoustomerPhone;
	}

	public void setCoustomerPhone(String coustomerPhone) {
		CoustomerPhone = coustomerPhone;
	}

}
