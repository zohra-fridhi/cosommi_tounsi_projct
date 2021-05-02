package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.type.CalendarDateType;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "User")
public class User implements Serializable{
	private static final long serialVersionUID = -1781141388061587690L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Email
	private String mail;
	@NotNull
	private String login;
	@NotNull
	private String password;
	private String sex;
	@Pattern(regexp = "[a-zA-Z ]+", message = "firstname must contain only characters")
	private String firstname;
	@Pattern(regexp = "[a-zA-Z ]+", message = "lastname must contain only characters")
	private String lastname;
	@Pattern(regexp="((\\+|00)216)?[0-9]{8}")
	private String tel;
	private String adress;
	@NotNull
	@Size(min=4,max=4)
	private String postalcode;
	@NotNull
	@Size(min=8,max=8)
	private String cin;
	@Enumerated(EnumType.STRING)
	Role role;
	private Date birthday;
	
	
	
	
	
}