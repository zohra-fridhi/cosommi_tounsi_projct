package tn.esprit.spring.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity

public class Paiement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long  idPaiement ;
	 private String nomCLient ;
	 private Double Totale ;
	
	
	@Enumerated(EnumType.STRING)
	 Type typepaiement ;
	
	@Enumerated(EnumType.STRING)
	   RechercheP recherchePaiement ;
	
	
	
	
	
	
	
	
	
	
	
	

	public Paiement() {
		super();
	
	}

	public Paiement(Long idPaiement, String nomCLient, Double totale, Type typepaiement, RechercheP recherchePaiement) {
		super();
		this.idPaiement = idPaiement;
		this.nomCLient = nomCLient;
		this.Totale = totale;
		this.typepaiement = typepaiement;
		this.recherchePaiement = recherchePaiement;
	}

	@Override
	public String toString() {
		return "Paiement [idPaiement=" + idPaiement + ", nomCLient=" + nomCLient + ", Totale=" + Totale
				+ ", typepaiement=" + typepaiement + ", recherchePaiement=" + recherchePaiement + "]";
	}

	public Long getIdPaiement() {
		return idPaiement;
	}

	public void setIdPaiement(Long idPaiement) {
		this.idPaiement = idPaiement;
	}

	public String getNomCLient() {
		return nomCLient;
	}

	public void setNomCLient(String nomCLient) {
		this.nomCLient = nomCLient;
	}

	public Double getTotale() {
		return Totale;
	}

	public void setTotale(Double totale) {
		Totale = totale;
	}

	public Type getTypepaiement() {
		return typepaiement;
	}

	public void setTypepaiement(Type typepaiement) {
		this.typepaiement = typepaiement;
	}

	public RechercheP getRecherchePaiement() {
		return recherchePaiement;
	}

	public void setRecherchePaiement(RechercheP recherchePaiement) {
		this.recherchePaiement = recherchePaiement;
	}

	
	
	
	
	
	
	
	
}