package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;





@Entity

@Table(name="StockageProduit")

public class StockageProduit {	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduit;
	
	@Column	(name="nomProduit" ,length=70 , nullable=false)
	private String nomProduit;
	
	@Positive
    @Column	(name="prixAchat" , nullable=false)
	private float prixAchat;
	
	@Positive
    @Column	(name="prixVente" , nullable=false)
	private float prixVente ;
   @Size(min=3, max=60 )
   @Column	(name="lieuStockage" , nullable=false)
	private String lieuStockage;
   @Positive
   @Column	(name="quantityProduit" , nullable=false)
    private int quantityProduit;
  
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE", nullable=true)
	private Date dateCreation;
	@PrePersist
	private void onCreate() {
		dateCreation = new Date();
	}
	
	public StockageProduit() {
		super();
	}


	public Long getIdProduit() {
		return idProduit;
	}


	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}


	public String getNomProduit() {
		return nomProduit;
	}


	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}


	public float getPrixAchat() {
		return prixAchat;
	}
     
	
	
	public void setPrixAchat(float prixAchat) {
		this.prixAchat = prixAchat;
	}


	public float getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(float prixVente) {
		this.prixVente = prixVente;
	}


	public String getLieuStockage() {
		return lieuStockage;
	}


	public void setLieuStockage(String lieuStockage) {
		this.lieuStockage = lieuStockage;
	}


	public int getQuantityProduit() {
		return quantityProduit;
	}


	public void setQuantityProduit(int quantityProduit) {
		this.quantityProduit = quantityProduit;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	

    @Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixAchat=" + prixAchat
				+ ", prixVente=" + prixVente + ", lieuStockage=" + lieuStockage + ", QuantityProduit=" + quantityProduit
				+ ", dateCreation=" + dateCreation + "]";
	}
	


}
