package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Publication;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long>{
	    Optional <List<Comment>> findByPublicationIdOrderByScoreDesc(Long id);
	    
	    
}
