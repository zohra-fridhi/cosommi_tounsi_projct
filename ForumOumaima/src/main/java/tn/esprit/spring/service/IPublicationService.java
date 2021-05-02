package tn.esprit.spring.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.RatePub;

public interface IPublicationService {
	public Publication createOrUpdate(Publication publication);
	public void delete(Long id);
	Publication getById (Long id) throws NoSuchElementException;
	List<Publication> findByUserId(Long id);
	Publication rate(Long idPublication, Long idUser, RatePub rate);
	public List<Publication> news();
	public void save(MultipartFile[] uploadedFiles,Long idPub);
	List<Publication> suggestion(Long idUser);
	List<Publication> getAllPublication();
	public List<Publication> getPubBycategorie(Long id);
}
