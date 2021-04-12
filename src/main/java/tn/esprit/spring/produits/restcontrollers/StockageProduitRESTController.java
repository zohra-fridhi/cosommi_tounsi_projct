package tn.esprit.spring.produits.restcontrollers;



import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.produits.entities.StockageProduit;
import tn.esprit.spring.produits.service.StockageProduitService;

@RestController  // Pour définir un controlleur qui va fonctionner au mode rest 
@RequestMapping("/api")
@CrossOrigin
public class StockageProduitRESTController {
	
	@Autowired
	StockageProduitService produitService;
	
	
    //   http://localhost:8081/produits/api/save
	@RequestMapping(value="/save" ,method = RequestMethod.POST)
	public StockageProduit createProduit(  @Valid  @RequestBody  StockageProduit produit) {
			return produitService.saveProduit(produit);
	}
	
	
	  //  http://localhost:8081/produits/api/{id}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
			produitService.deleteProduitById(id);
	}
	  
      //  http://localhost:8081/produits/api
	@RequestMapping(   method = RequestMethod.PUT)
	public StockageProduit updateProduit(@RequestBody StockageProduit produit) {
		return produitService.updateProduit(produit);
	}
	
   //  http://localhost:8081/produits/api
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public List<StockageProduit> getAllProduits()
	{
		return produitService.getAllProduits();
	}
	
	   //  http://localhost:8081/produits/api/{id}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	 public StockageProduit getProduitById(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
	 }
	
	
	
	

}
