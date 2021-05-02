package tn.esprit.spring.control;

import java.util.List;
import java.util.NoSuchElementException;

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
import tn.esprit.spring.entity.CategoriePublication;
import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.service.ICategoriePublicationService;


@AllArgsConstructor
@RestController
@RequestMapping("/categoriepublication")
public class CategoriePublicationController {

	private final ICategoriePublicationService categoriepublicationService;
	
	 @GetMapping
	 public List<CategoriePublication>  getAllCategorie(){
		 return categoriepublicationService.getAllCategorie();}
	
	@PostMapping("/create")
	public CategoriePublication create(@RequestBody CategoriePublication categoriepublication) {
		categoriepublicationService.createOrUpdate(categoriepublication);
		return categoriepublication;
	}

	
	@PutMapping("/update")
	public CategoriePublication update(@RequestBody CategoriePublication categoriepublication) {
		if (categoriepublication.getId()==null) {
			throw new NoSuchElementException();
		}
		return categoriepublicationService.createOrUpdate(categoriepublication);
		
	}

	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		categoriepublicationService.delete(id);
	}
	
	@ExceptionHandler({ NoSuchElementException.class })
    public ResponseEntity handleException() {
      return new ResponseEntity<>("There's no categorie publication with such ID", HttpStatus.NOT_FOUND) ; 
    }

}
