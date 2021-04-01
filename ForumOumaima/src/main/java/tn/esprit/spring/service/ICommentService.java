package tn.esprit.spring.service;


import java.util.List;
import java.util.NoSuchElementException;


import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.RateCom;


public interface ICommentService {
	
	public Comment createOrUpdate(Comment comment);
	public void delete(Long id);
	Comment getById (Long id) throws NoSuchElementException;
	List<Comment> findByPublicationIdOrderByScoreDesc(Long id);
	 Comment rate(Long idComment, Long idUser, RateCom rate);
	
}
