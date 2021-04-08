package tn.esprit.spring.service;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Channel;
import tn.esprit.spring.repository.PublicityRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class PublicityService implements IPublicityService{
	@Autowired
	private PublicityRepository pubRep;
	@Autowired
	private UserRepository userRep;
    
	@Override
	  public Publicity store(MultipartFile file,Publicity p) throws IOException {
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    Publicity FileDB = new Publicity(p.getPubId(), p.getName(), p.getStartDate(), p.getEndDate(), p.getNbrVue(), file.getBytes(),CoutSurLeNbrDeJour(p),
			p.getStartAgeCible(), p.getEndAgeCible(), p.getChannel(), p.getUsers(),fileName,p.getGenderCible());

		    return pubRep.save(FileDB);
		  }

		 
	@Override
	  public List<Publicity> getAllFiles() {
	    return (List) pubRep.findAll();
	  }

	@Override
	public Publicity update(Publicity p, int id) {
		Publicity p1 = findOne(id);
		p1.setStartDate(p1.getStartDate());
		p1.setEndDate(p1.getEndDate());
		return pubRep.save(p1);
		
	}

	@Override
	public Publicity findOne(int id) {
		Publicity p= pubRep.findById(id).get();
		return p;
	}

	@Override
	public void delete(int id) {
		pubRep.deleteById(id);
		
	}

	@Override
	public String getNameById(int id) {
		String name = pubRep.findById(id).get().getName();
		return name;
	}

	@Override
	public float CoutSurLeNbrDeJour(Publicity p)  {
		if(p.getStartDate()!=null && p.getEndDate()!=null){
			int NbrJourPub = DifferenceJourStartDateEndDate(p.getStartDate(), p.getEndDate());
			System.out.println("nombre de jour"+NbrJourPub);
			float cout = 0;
			if (NbrJourPub <= 30) {
				return cout += 5 * NbrJourPub;
			}
			if (NbrJourPub > 30 && NbrJourPub <= 90) {
				return cout += 8 * NbrJourPub;
			}
			if (NbrJourPub > 90 && NbrJourPub <= 180) {
				return cout += 12 * NbrJourPub;
			} else {
				return cout += 20 * NbrJourPub;
			}
			}
			else return 0;
		
	}
	

	


	
	public static int DifferenceJourStartDateEndDate(Date startDate, Date endDate)  {
	    float diff = endDate.getTime() - startDate.getTime();
	    System.out.println("diffff"+diff);
	    float res = (diff / (1000*60*60*24));
	    System.out.println("ressss"+res);
		return (int) res;
	  
	}


	@Override
	public List<Publicity> findPublicityByUser(int age) {
		List<Publicity> listPublicities = pubRep.findPublicityUser(age);
		return listPublicities;
	}

	@Override
	public int NbrUserAgeBetwin(int startAgeCible, int endAgeCible) {
	
		return pubRep.CountUserWithAgeBetwin(startAgeCible, endAgeCible);
	}


	@Override
	public int NbrUserFemmeAgeBetwin(int startAgeCible, int endAgeCible) {
		return pubRep.CountUserFemmeWithAgeBetwin(startAgeCible, endAgeCible);
	}


	@Override
	public int NbrUserHommeAgeBetwin(int startAgeCible, int endAgeCible) {
		return pubRep.CountUserHommeWithAgeBetwin(startAgeCible, endAgeCible);
	}
	@Override
	public int CountUserCible(int ageCibledebut, int ageCibleFin, String gender) {
		int nbrUser = 0;
		if (gender.equals("HOMME")) {
			nbrUser += NbrUserHommeAgeBetwin(ageCibledebut, ageCibleFin);
		}
		if (gender.equals("FEMME")) {
			nbrUser += NbrUserFemmeAgeBetwin(ageCibledebut, ageCibleFin);
		}
		if (gender.equals("TOUS")) {
			nbrUser += NbrUserAgeBetwin(ageCibledebut, ageCibleFin);
		}

		return nbrUser;
		
	}

	}
	


	


