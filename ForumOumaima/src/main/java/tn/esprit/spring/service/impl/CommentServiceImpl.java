package tn.esprit.spring.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.RateCom;
import tn.esprit.spring.repository.ICommentRepository;
import tn.esprit.spring.service.ICommentService;
import tn.esprit.spring.utility.BadWordException;
import tn.esprit.spring.utility.BadWords;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements ICommentService{

	private final ICommentRepository commentRepository;
    
	@Override
	public List<Comment> getAllComment() {
		return commentRepository.findAll();
	}
	
	@Override
	public Comment createOrUpdate(Comment comment) throws BadWordException {
		if (comment.getId()!=null) 
		{
				getById(comment.getId());
		}
		comment.setCreationDate(LocalDateTime.now());
		BadWords.loadConfigs();
		comment.setContent(BadWords.filterText(comment.getContent()));
		return commentRepository.save(comment);
	}

	@Override
	public void delete(Long id) {
		commentRepository.deleteById(id);	
	}
	
	@Override
	public Comment getById(Long id) throws NoSuchElementException{
		Optional<Comment> comment = commentRepository.findById(id);
		if (comment.isPresent()) return comment.get();
		throw new NoSuchElementException();
	}
	
	@Override
	public List<Comment> findByPublicationIdOrderByScoreDesc(Long id) {
		return commentRepository.findByPublicationIdOrderByScoreDesc(id).orElse(new ArrayList());
		
	}

	@Override
	public Comment rate(Long idComment, Long idUser, RateCom rate) {
		Comment comment= getById(idComment);
		 RateCom userRate = comment.getRatingCom().get(idUser);
		 if (userRate != null) {
			 if(userRate==RateCom.LIKE ||userRate==RateCom.LAUGH || userRate==RateCom.LOVE) 
			 { 
			comment.setScore(comment.getScore()-1);
			 }	
			 else {
				System.out.println(comment.getScore());
				 comment.setScore(comment.getScore()+1);	 
			 }
		 }
		 if(rate==RateCom.LIKE ||rate==RateCom.LAUGH || rate==RateCom.LOVE) 
		 {  
		comment.setScore(comment.getScore()+1);
		 }	
		 else {
			 comment.setScore(comment.getScore()-1);	 
		 }
		comment.getRatingCom().put(idUser, rate);
		return commentRepository.save(comment);
		 
		
	}

	
	
	
	
}
