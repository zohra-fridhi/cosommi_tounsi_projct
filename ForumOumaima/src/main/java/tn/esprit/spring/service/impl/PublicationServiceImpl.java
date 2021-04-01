package tn.esprit.spring.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.RatePub;
import tn.esprit.spring.repository.IPublicationRepository;
import tn.esprit.spring.service.IPublicationService;

@AllArgsConstructor
@Service
public class PublicationServiceImpl implements IPublicationService{
	private final IPublicationRepository publicationRepository;

	@Override
	public Publication createOrUpdate(Publication publication) {
		if (publication.getId()!=null) 
		{
				getById(publication.getId());
		}
		publication.setDatePublication(LocalDateTime.now());
		return publicationRepository.save(publication);
	}

	@Override
	public void delete(Long id) {
		publicationRepository.deleteById(id);
		
	}

	@Override
	public Publication getById(Long id) throws NoSuchElementException {
		Optional<Publication> publication = publicationRepository.findById(id);
		if (publication.isPresent()) return publication.get();
		throw new NoSuchElementException();
	}

	@Override
	public List<Publication> findByUserId(Long id) {
		System.out.println(id);
		return publicationRepository.findByUserId(id).orElse(new ArrayList());
	}
	
	
	@Override
	public Publication rate(Long idPublication, Long idUser, RatePub rate) {
		Publication publication= getById(idPublication);
		 RatePub userRate = publication.getRatingPub().get(idUser);
		 if (userRate != null) {
				if(userRate==RatePub.VERY_EXCELLENT){
						 publication.setScore(publication.getScore()-5);
				    }
				else if (userRate==RatePub.EXCELLENT) 
					{
						 publication.setScore((float) (publication.getScore()-4.5));
					 }
				 else if (userRate==RatePub.VERY_GOOD)  
					 {
						 publication.setScore((float) (publication.getScore()-4));
					 }
				 else if (userRate==RatePub.GOOD)  
					 {
						 publication.setScore((float) (publication.getScore()-3.5));
					 }
			    
			     else if (userRate==RatePub.ABOVE_AVERAGE) 
				      {
					     publication.setScore((float) (publication.getScore()-3));
				      }
		    	 else if (userRate==RatePub.AVERAGE) 
			    	  {  
			    		 publication.setScore((float) (publication.getScore()-2.5));
			          }
				 else if (userRate==RatePub.POOR) 
					   {
						  publication.setScore((float) (publication.getScore()-2));
			           }
				  else if (userRate==RatePub.VERY_POOR) 
					    {
						   publication.setScore((float) (publication.getScore()-1.5));
			            }
			      else if (userRate==RatePub.BAD) 
					    {
						    publication.setScore((float) (publication.getScore()-1));  
					    }
			      else 
					    {
						    publication.setScore((float) (publication.getScore()-0.5));
					    }
				 }
		 
		 if(rate==RatePub.VERY_EXCELLENT) 
			 { 
				 publication.setScore(publication.getScore()+5); 
			 }
		 else if (rate==RatePub.EXCELLENT) 
			{
				 publication.setScore((float) (publication.getScore()+4.5));
			 }
		 else if (rate==RatePub.VERY_GOOD)  
			 {
				 publication.setScore((float) (publication.getScore()+4));
			 }
		 else if (rate==RatePub.GOOD)  
			 {
				 publication.setScore((float) (publication.getScore()+3.5));
			 }
	    
	     else if (rate==RatePub.ABOVE_AVERAGE) 
		      {
			     publication.setScore((float) (publication.getScore()+3));
		      }
    	 else if (rate==RatePub.AVERAGE) 
	    	  {  
	    		 publication.setScore((float) (publication.getScore()+2.5));
	          }
		 else if (rate==RatePub.POOR) 
			   {
				  publication.setScore((float) (publication.getScore()+2));
	           }
		  else if (rate==RatePub.VERY_POOR) 
			    {
				   publication.setScore((float) (publication.getScore()+1.5));
	            }
	      else if (rate==RatePub.BAD) 
			    {
				    publication.setScore((float) (publication.getScore()+1));  
			    }
	      else 
			    {
				    publication.setScore((float) (publication.getScore()+0.5));
			    }
     	  
		 publication.getRatingPub().put(idUser, rate);
		return publicationRepository.save(publication);
	}

	@Override
	public List<Publication> news() {
		
		return publicationRepository.findFirst5ByOrderByDatePublicationDesc();
	}
	
	
	
	
	
	
	
	
	
	
}
