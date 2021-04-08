package tn.esprit.spring.control;

import java.util.ArrayList;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.service.IProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	
	@Autowired(required = true)
	IProductService productService;
	
	@GetMapping( "/products")
	@ResponseBody
	public  List<Product> retrieveProductByName(@Param(value = "name") String name,@Param(value = "type") String type) {
		List<Product> products = new ArrayList<>();
		products= productService.retrieveProductByNameAndType(name,type);
		return products;}
	
	@GetMapping("/products/{idProduit}")
	public ResponseEntity<Product> getProduitById(@PathVariable(value = "idProduit") int idProduct)
			{
		Product product = productService.getProductById(idProduct);
				return ResponseEntity.ok().body(product);
	}
	

		
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody   Product productCreateRequests) {
		return ResponseEntity.ok().body(productService.addProduct(productCreateRequests));
		
	}
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable(value = "id")  int id, @RequestBody Product product) {
		return productService.updateProduct(product, id);
	}
	@DeleteMapping("/products/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") int id)
	 {
		String result = productService.deleteProduct(id);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put(result, Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/Category/{idCategory}")
	public List<String> findProductCategory(@PathVariable(value = "idCategory") int cat_id) {
		return productService.findProductNameCategory(cat_id);
	}

	@PostMapping("/Affect/{idP}/{idC}")
	public void affectProduct(@PathVariable(value="idP") int prodId, @PathVariable(value="idC") int catId ) {
	productService.AffectProductToCategory(prodId, catId);
	}
	
	@GetMapping("/Order")
	public List<Product> getProductOrderByPrice(){
		return productService.orderProductByPrice();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	



}
