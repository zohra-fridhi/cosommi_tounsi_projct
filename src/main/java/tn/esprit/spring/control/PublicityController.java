package tn.esprit.spring.control;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.stream.Collectors;

import tn.esprit.spring.entities.Channel;
import tn.esprit.spring.entities.GenderCible;
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.service.IPublicityService;
@RestController
@RequestMapping("/Publicity")
public class PublicityController {
	@Autowired(required = true)
	IPublicityService pubService;




	@PostMapping("/add")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("name")String name,@RequestParam("startDate")Date startDate,@RequestParam("endDate") Date endDate,@RequestParam("nbrVue") int nbrVue, 
			@RequestParam("startAgeCible")int startAgeCible, @RequestParam("endAgeCible")int endAgeCible, @RequestParam("genderCible")GenderCible genderCible,@RequestParam("channel") Channel channel) {
		String message = "";
		try {
			Publicity p=new Publicity();
			p.setName(name);
			p.setStartDate(startDate);
			p.setEndDate(endDate);
			p.setNbrVue(nbrVue);
			p.setStartAgeCible(startAgeCible);
			p.setEndAgeCible(endAgeCible);
			p.setGenderCible(genderCible);
			p.setChannel(channel);
			pubService.store(file,p);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			ResponseMessage msg = new ResponseMessage(message);

			return ResponseEntity.status(HttpStatus.OK).body(msg);
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	  @GetMapping("/displayAll")
	  public ResponseEntity<List<Publicity>> getListFiles() {
	    List<Publicity> files = pubService.getAllFiles();
	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	@PutMapping("/edit/{id}")
	public Publicity editPublicity(@PathVariable(value = "id") int idPublicity, @RequestBody Publicity p) {
		return pubService.update(p, idPublicity);
	}
	@GetMapping("{idPublicity}")
	public String findNameByID(@PathVariable(value = "idPublicity") int idPub) {
		return pubService.getNameById(idPub);
	}
	@GetMapping("/get/{idPub}")
	public ResponseEntity<Publicity> getPublicityById(@PathVariable(value = "idPub") int idPub)
			 {
		Publicity pub = pubService.findOne(idPub);
		return ResponseEntity.ok().body(pub);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePublicity(@PathVariable(value = "id") int idPub) {
		pubService.delete(idPub);
		return ResponseEntity.ok("Publicity deleted with succes");
	}

	@GetMapping("/calculCout/{idPub}")
	public ResponseEntity<Float> getCoutByPublicite(@PathVariable(value = "idPub") int idPub)
			 {
		Publicity pub = pubService.findOne(idPub);
		System.out.println("enf    date :"+pub.getEndDate());
		System.out.println("start date :"+pub.getStartDate());
		float res = 0;
		try {
			res = pubService.CoutSurLeNbrDeJour(pub);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(res);
	}
	  @GetMapping("/PubUser")
	  public ResponseEntity<List<Publicity>> getPublicityByUser(@RequestParam("age")int age) {
	    List<Publicity> publicities = pubService.findPublicityByUser(age);
	    return ResponseEntity.status(HttpStatus.OK).body(publicities);
	  }
	  
	  @GetMapping("/Count")
	  public int nbrUserCible(@RequestParam("startAgeCible") int startAgeCible,@RequestParam("endAgeCible")int endAgeCible,@RequestParam("genderCible")String genderCible) {
		  return pubService.CountUserCible(startAgeCible, endAgeCible, genderCible);
	  }
}
