package tn.esprit.spring.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.produits.entities.Facture;

import tn.esprit.spring.produits.service.FactureService;

@RestController
@RequestMapping("/apiF")
@CrossOrigin
public class FactureRESTController {
	
    @Autowired
    
    FactureService Factservice ;
    
    
    @RequestMapping(value="/saveF" , method = RequestMethod.POST)
    public Facture saveFacture(@RequestBody Facture facture){
    	
    	
    	return  Factservice.saveFacture(facture);
    	
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteFacture(@PathVariable("id") Long id)
	{
			Factservice.deleteFactureById(id);
	}
	
    
    @RequestMapping(method = RequestMethod.PUT)
    public Facture updateFacture(@RequestBody Facture facture) {
    	
		return Factservice.updateFacture(facture);
	}
    
    	
    
    @RequestMapping(method=RequestMethod.GET)
    public List<Facture> getAllFactures()
	{
		return Factservice.getAllFactures();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Facture getFactureById(@PathVariable("id") Long id) {
		return Factservice.getFacture(id);
	}
	
	
    

}
