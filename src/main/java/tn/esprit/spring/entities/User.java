package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="USER")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	String firstName;
	String lasName;
	String email;
	String adress;
	int cin;
	int tel;
	int age;
	String sexe;
	@Enumerated(EnumType.STRING)
	Role role;
	@OneToMany
	@JoinTable(name="T_TU_TP")
	private Set<Product> products;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_USER_PUBLICITY")
	private Set<Publicity> publicities;
	
	
	
	@JoinTable(name = "T_USER_STOCKAGE")
	@OneToMany(cascade = CascadeType.ALL)
	private Set<StockageProduit> StockageProduit;
	@JoinTable(name = "T_USER_FACTURE")
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Facture> Facture;
	@JoinTable(name = "T_USER_PAIEMENT")
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Paiement> Paiement;
	
	
	
	
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Set<Publicity> getPublicities() {
		return publicities;
	}
	public void setPublicities(Set<Publicity> publicities) {
		this.publicities = publicities;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasName() {
		return lasName;
	}
	public void setLasName(String lasName) {
		this.lasName = lasName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User() {}
}
