package tn.esprit.spring.service;



import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;



import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.entities.Channel;

public interface IPublicityService {
	public Publicity store(MultipartFile file,Publicity p) throws IOException;

	public Publicity findOne(int id);
	public Publicity update(Publicity p,int id);
	public void delete(int id);
	public String getNameById(int id);
	
	public List<Publicity> getAllFiles() ;
	
	List<Publicity> findPublicityByUser(int age);
	float CoutSurLeNbrDeJour( Publicity p) throws ParseException;
	int NbrUserAgeBetwin(int startAgeCible, int endAgeCible);
	int NbrUserFemmeAgeBetwin(int startAgeCible, int endAgeCible);
	int NbrUserHommeAgeBetwin(int startAgeCible, int endAgeCible);
	int CountUserCible(int ageCibledebut, int ageCibleFin, String gender);
}
