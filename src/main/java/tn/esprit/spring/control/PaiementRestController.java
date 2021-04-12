package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Paiement;

import tn.esprit.spring.service.PaiementService;

@RestController
@RequestMapping("/apiPai")
@CrossOrigin
public class PaiementRestController {
	
	@Autowired
	PaiementService paiementService ;
	
	
	
	 //   http://localhost:8081/produits/apiPai/save
	@RequestMapping(value="/save" ,method = RequestMethod.POST)
	public Paiement createPaiement(@RequestBody Paiement paiement) {
			return paiementService.savePaiement(paiement);
	}
	
	  // http://localhost:8081/produits/apiPai/{idPaiement}
	@RequestMapping(value="/{idPaiement}",method = RequestMethod.DELETE)
	public void deletePaiement(@PathVariable("idPaiement") Long idPaiement)
	{
		paiementService.deletePaiementById(idPaiement);
	}
	
	// http://localhost:8081/produits/apiPai/
	@RequestMapping(method = RequestMethod.PUT)
	public Paiement updatePaiement(@RequestBody Paiement paiement) {
		return paiementService.updatePaiement(paiement);
	}
	
	// http://localhost:8081/produits/apiPai/
	@RequestMapping(method=RequestMethod.GET)
	public List<Paiement> getAllPaiements()
	{
		return paiementService.getAllPaiements();
	}
	
	// http://localhost:8081/produits/apiPai/{idPaiement}
	@RequestMapping(value="/{idPaiement}",method = RequestMethod.GET)
	 public Paiement getPaiementById(@PathVariable("idPaiement") Long idPaiement) {
		return paiementService.getPaiement(idPaiement);
	 }

}
