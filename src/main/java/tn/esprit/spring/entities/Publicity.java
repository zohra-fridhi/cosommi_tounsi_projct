package tn.esprit.spring.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PUBLICITY")
public class Publicity implements Serializable {

	private static final long serialVersionUID = 5253089472092725769L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pubId;
	String name;
	@Temporal(TemporalType.DATE)
	Date startDate;
	@Temporal(TemporalType.DATE)
	Date endDate;
	int nbrVue;
	@Lob
	byte[] image;
	float cout;
	int startAgeCible;
	int endAgeCible;
	@Enumerated(EnumType.STRING)
	Channel channel;
	String fileName;
	@Enumerated(EnumType.STRING)
	private GenderCible genderCible;

	@ManyToMany(mappedBy="publicities", cascade = CascadeType.ALL)
	private Set<User> users;
	

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public byte[] getImage() {
		return image;
	}
	public int getStartAgeCible() {
		return startAgeCible;
	}
	public void setStartAgeCible(int startAgeCible) {
		this.startAgeCible = startAgeCible;
	}
	public int getEndAgeCible() {
		return endAgeCible;
	}
	public void setEndAgeCible(int endAgeCible) {
		this.endAgeCible = endAgeCible;
	}
	public float getCout() {
		return cout;
	}
	public void setCout(float cout) {
		this.cout = cout;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public int getPubId() {
		return pubId;
	}
	public void setPubId(int pubId) {
		this.pubId = pubId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getNbrVue() {
		return nbrVue;
	}
	public void setNbrVue(int nbrVue) {
		this.nbrVue = nbrVue;
	}
	
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public GenderCible getGenderCible() {
		return genderCible;
	}
	public void setGenderCible(GenderCible genderCible) {
		this.genderCible = genderCible;
	}
	public Publicity() {}
	public Publicity(int pubId, String name, Date startDate, Date endDate, int nbrVue, byte[] image, float cout,
			int startAgeCible, int endAgeCible, Channel channel, Set<User> users,String fileName,GenderCible genderCible) {
		super();
		this.pubId = pubId;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.nbrVue = nbrVue;
		this.image = image;
		this.cout = cout;
		this.startAgeCible = startAgeCible;
		this.endAgeCible = endAgeCible;
		this.channel = channel;
		this.users = users;
		this.fileName=fileName;
		this.genderCible=genderCible;
	}
	
	

}
