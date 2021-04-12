package tn.esprit.spring.entity;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "History")
public class History implements Serializable{

	public History(User user, RatePub rate, Publication idPublication) {
		this.user = user;
		this.rating = rate;
		this.publication = idPublication;
		this.rateDate = LocalDate.now();
	}

	private static final long serialVersionUID = 5855479551853852092L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	@ManyToOne
	private Publication publication; 
	private LocalDate rateDate;
	private RatePub rating;
	private Long idPub; 
	
	@ManyToOne
	private User user;
	
}