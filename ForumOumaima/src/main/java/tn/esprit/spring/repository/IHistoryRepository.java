package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.History;

@Repository
public interface IHistoryRepository extends JpaRepository<History, Long>{

	List<History> findFirst3ByUserIdOrderByRatingDesc(Long id);

}
