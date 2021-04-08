package tn.esprit.spring.control;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Category;
import tn.esprit.spring.service.ICategoryService;


@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired(required=true)
	ICategoryService icategoryService;
	
	@PostMapping("/add")
	public Category addCategory(@Valid @RequestBody Category c) {
		return icategoryService.save(c);
	}
	@GetMapping("/display")
	public List<Category> displayCategorie() {
		return icategoryService.findAll();
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable(value = "id") int idCategory) {
		icategoryService.delete(idCategory);
		return ResponseEntity.ok("Category deleted with succes");
	}
	@PutMapping("/edit/{id}")
	public Category editCategory(@PathVariable(value = "id") int idCategory, @Valid @RequestBody Category c) {
		return icategoryService.update(c, idCategory);
	}
	@GetMapping("{idCat}")
	public String findNameByID(@PathVariable(value = "idCat") int idCat) {
		return icategoryService.getWordingById(idCat);
	}
	@GetMapping("/get/{idCat}")
	public ResponseEntity<Category> getCategoryById(@PathVariable(value = "idCat") int idCat)
			{
		Category cat = icategoryService.findOne(idCat);
				return ResponseEntity.ok().body(cat);
	}

}
