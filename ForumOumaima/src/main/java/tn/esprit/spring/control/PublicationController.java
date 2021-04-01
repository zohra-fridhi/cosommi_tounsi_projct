package tn.esprit.spring.control;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.RateCom;
import tn.esprit.spring.entity.RatePub;
import tn.esprit.spring.service.IPublicationService;



@AllArgsConstructor
@RestController
@RequestMapping("/publication")
public class PublicationController {
	
	private final IPublicationService publicationService;
	
	@PostMapping("/create")
	public Publication create(@RequestBody @Valid Publication publication) {
		publicationService.createOrUpdate(publication);
	return publication;
	}

	@PutMapping("/update")
	public Publication update(@RequestBody @Valid Publication publication) {
		if (publication.getId()==null) {
			throw new NoSuchElementException();
		}
		return publicationService.createOrUpdate(publication);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		publicationService.delete(id);
	}
	
    @GetMapping("/find-user-publication/{id}")
    public List<Publication> findByUserId(@PathVariable("id")Long id){
		return publicationService.findByUserId(id);
    	
    }
    @GetMapping("/rate/{idPublication}/{idUser}/{rate}")
	public Publication rate(@PathVariable("idPublication")Long idPublication,
			@PathVariable("idUser")Long idUser,
			@PathVariable("rate")RatePub rate) {
		return publicationService.rate(idPublication,idUser,rate);
		
	}
    @ExceptionHandler({ NoSuchElementException.class })
    public ResponseEntity handleException() {
      return new ResponseEntity<>("There's no publication with such ID", HttpStatus.NOT_FOUND) ; 
    }
    
    @GetMapping("/new")
   public List<Publication> news(){
    	
    	return publicationService.news();
    }
    
}
