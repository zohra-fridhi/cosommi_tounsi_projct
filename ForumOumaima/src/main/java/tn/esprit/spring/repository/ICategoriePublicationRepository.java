package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.CategoriePublication;


@Repository
public interface ICategoriePublicationRepository extends JpaRepository<CategoriePublication, Long>{

}
