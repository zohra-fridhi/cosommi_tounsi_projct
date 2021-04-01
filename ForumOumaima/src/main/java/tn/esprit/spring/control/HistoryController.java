package tn.esprit.spring.control;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.esprit.spring.entity.History;
import tn.esprit.spring.service.IHistoryService;


@AllArgsConstructor
@RestController
@RequestMapping("/history")
public class HistoryController {
	
	private final IHistoryService historyService;
	@PostMapping("/create")
	public History create(@RequestBody History history) {
		historyService.createOrUpdate(history);
		return history;
     }
	@PutMapping("/update")
	public History update(@RequestBody History history) {
		if (history.getId()==null) {
			throw new NoSuchElementException();
		}
		return historyService.createOrUpdate(history);
		
	}

	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		historyService.delete(id);
	}
	
	@ExceptionHandler({ NoSuchElementException.class })
    public ResponseEntity handleException() {
      return new ResponseEntity<>("There's no history with such ID", HttpStatus.NOT_FOUND) ; 
    }
}
