package tn.esprit.spring.entity;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity 
@Table(name = "comment")
public class Comment implements Serializable{
	
	private static final long serialVersionUID = 74973313000858900L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	@NotBlank(message="the content is required")
	@Size(max=150)
	private String content;
	@ManyToOne(targetEntity=User.class)
	private User user;
	private LocalDateTime creationDate;
	private Integer score=0;
@ElementCollection
	private Map<Long,RateCom> ratingCom;
	
	@ManyToOne(targetEntity=Publication.class)
	Publication publication;
	

}
