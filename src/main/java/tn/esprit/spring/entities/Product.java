package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = -5475571523396197637L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int prodId;
	@NotEmpty(message ="Type is required")
	private String type;
	
	@NotEmpty(message ="Name is required")
	String name;
	float price;
	String description;
	@Pattern(regexp="619[a-zA-Z0-9]{10}",message="barcode must start with 619")
	String barCode;
	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name="FK_CATEGORY_ID")
	private Category category;

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Product() {}
	public Product(int prodId, String type, String name, float price, String description,
			 String barCode,Category category) {
		super();
		this.prodId = prodId;
		this.type = type;
		this.name = name;
		this.price = price;
		this.description = description;
		this.barCode = barCode;
		this.category = category;
	}

}
