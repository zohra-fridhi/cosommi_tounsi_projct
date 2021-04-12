package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity

	public class Facture  {
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long  idFacture ;
	private String nomclient ;
	private float calculmontant ;
	
	 
 	public String getNomclient() {
		return nomclient;
	}









	public void setNomclient(String nomclient) {
		this.nomclient = nomclient;
	}









	public float getCalculmontant() {
		return calculmontant;
	}









	public void setCalculmontant(float calculmontant) {
		this.calculmontant = calculmontant;
	}





	@Temporal(TemporalType.DATE)
 	private Date date ;
 	
 	@Enumerated(EnumType.STRING)
 	   RechercheF rechercheFacture ;

 	
 	
 	
 	
 	
 	


	public Facture(Long idFacture, String nomclient, float calculmontant, Date date, RechercheF rechercheFacture) {
		super();
		this.idFacture = idFacture;
		this.nomclient = nomclient ;
		this.calculmontant = calculmontant ;
		this.date = date;
		this.rechercheFacture = rechercheFacture;
	}









	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture +"  , nomclient="+ nomclient +" , calculmontant="+ calculmontant +", date=" + date + ", rechercheFacture=" + rechercheFacture + "]";
	}



	public Long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}




	


	
	


	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


	public RechercheF getRechercheFacture() {
		return rechercheFacture;
	}

	public void setRechercheFacture(RechercheF rechercheFacture) {
		this.rechercheFacture = rechercheFacture;
	}





	public Facture() {
		super();
	}

	} 
	


