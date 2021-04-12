package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "publication")
public class Publication implements Serializable{
	private static final long serialVersionUID = -1342701712719874836L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Publication Title is Required ")
	@Size(max=50,min=3)
	private String title;
	@Size(max=150)
	private String content;
	//@Pattern(regexp="https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)")
	private String picture;
	private LocalDateTime datePublication;
	private Float score=(float) 0;
	@ElementCollection
	private Map<Long,RatePub> ratingPub;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Comment> comments;
	@ManyToOne(targetEntity=CategoriePublication.class)
	private CategoriePublication categoriePublications;
	
	@ManyToOne(targetEntity=User.class)
	private User user;
	
}
