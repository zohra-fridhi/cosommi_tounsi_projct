package tn.esprit.spring.control;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
import tn.esprit.spring.service.ICommentService;
import tn.esprit.spring.utility.BadWordException;

@AllArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

	private final ICommentService commentService;
	@GetMapping("/getbyPostId/{id}")
	public List <Comment> getCommentByPublication(@PathVariable("id") Long id){
		return commentService.findByPublicationIdOrderByScoreDesc(id);
	}

	 @GetMapping
	 public List<Comment> getAllPublication(){
		 return commentService.getAllComment();
	 }
	
	@PostMapping("/create")
	public Comment create(@RequestBody @Valid Comment comment) throws BadWordException {
		
		commentService.createOrUpdate(comment);
		return comment;
	}

	
	@PutMapping("/update")
	public Comment update(@RequestBody @Valid Comment comment) throws BadWordException {
		if (comment.getId()==null) {
			throw new NoSuchElementException();
		}
		return commentService.createOrUpdate(comment);
		
	}

	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		commentService.delete(id);
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@ExceptionHandler({ NoSuchElementException.class })
    public ResponseEntity handleException() {
      return new ResponseEntity<>("There's no comment with such ID", HttpStatus.NOT_FOUND) ; 
    }
	
	@GetMapping("/find-comment-publication/{id}")
	public List<Comment> findByPublicationId(@PathVariable("id") Long id){
		return commentService.findByPublicationIdOrderByScoreDesc(id);
		
	}
	
	@GetMapping("/rate/{idComment}/{idUser}/{rate}")
	public Comment rate(@PathVariable("idComment")Long idComment,
			@PathVariable("idUser")Long idUser,
			@PathVariable("rate")RateCom rate) {
		return commentService.rate(idComment,idUser,rate);
		
		
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity handle(MethodArgumentNotValidException exception) {
	    List<ObjectError> violations = exception.getAllErrors();
	    String errorMessage = "";
	    if (!violations.isEmpty()) {
	        StringBuilder builder = new StringBuilder();
	        violations.forEach(violation -> builder.append(" " + violation.getDefaultMessage()));
	        errorMessage = builder.toString();
	    } else {
	        errorMessage = "ConstraintViolationException occured.";
	    }
	    return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	 }
	@ExceptionHandler(BadWordException.class)
	 public ResponseEntity badWordException() {
		return new ResponseEntity<>("there's bad Words", HttpStatus.BAD_REQUEST) ; 
    }
	
	
}
