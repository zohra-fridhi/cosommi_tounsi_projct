package tn.esprit.spring.repository;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.CategoriePublication;
import tn.esprit.spring.entity.Publication;

@Repository
public interface IPublicationRepository extends JpaRepository<Publication, Long>{

	Optional <List<Publication>> findByUserId(Long id);
	List<Publication> findFirst5ByOrderByDatePublicationDesc();
	@Query(value="select * from publication where id not in (select publication_id from comment  where publication_id is NOT NULL)", nativeQuery = true)
    public List<Publication> affichNotNullPublication();
	List<Publication> findByTitleContainsOrContentContains(String title, String content);
	List<Publication> findByCategoriePublicationsOrderByScoreDesc(CategoriePublication categoriePub);
}
