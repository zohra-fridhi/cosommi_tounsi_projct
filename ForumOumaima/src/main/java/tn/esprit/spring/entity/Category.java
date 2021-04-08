
package tn.esprit.spring.entity;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class Category implements Serializable {

	private static final long serialVersionUID = -5475571523396197637L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int catId;
	String wording;
	@OneToMany(mappedBy="category",cascade= {CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private Set<Product> products;
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	


	public Category(int catId, String wording) {
		super();
		this.catId = catId;
		this.wording = wording;
	}
	
	public Category(int catId, String wording, Set<Product> products) {
		super();
		this.catId = catId;
		this.wording = wording;
		this.products = products;
	}

	public int getCatId() {
		return catId;
	}



	public void setCatId(int catId) {
		this.catId = catId;
	}



	public String getWording() {
		return wording;
	}



	public void setWording(String wording) {
		this.wording = wording;
	}



	public Category() {}
}
