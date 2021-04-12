package tn.esprit.spring.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.StockageProduit;
import tn.esprit.spring.service.StockageProduitService;

@Controller

public class StockageProduitController {
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	
	@Autowired
	StockageProduitService produitService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createProduit";
	}
	
	@RequestMapping("/saveProduit")
	public String saveProduit(@ModelAttribute("produit") StockageProduit p,
							  @RequestParam("date") String date,
	                          ModelMap modelMap) throws 	ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	p.setDateCreation(dateCreation);
	
	StockageProduit saveProduit = produitService.saveProduit(p);
	String msg ="produit enregistré  "+saveProduit.getIdProduit();
	modelMap.addAttribute("tttttttttttttttttttttttttttttttttttttttttt", msg);
	return "createProduit";
	}
	 
	
	
	@RequestMapping("/updateProduit")
	public String updateProduit(@ModelAttribute("produit") StockageProduit produit,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	
	
	produitService.updateProduit(produit);
	List<StockageProduit> prods = produitService.getAllProduits();
	modelMap.addAttribute("produits", prods);
	return "listeProduits";
	}
	
	
	


}
