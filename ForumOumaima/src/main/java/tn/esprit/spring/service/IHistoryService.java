package tn.esprit.spring.service;

import java.util.NoSuchElementException;
import tn.esprit.spring.entity.History;

public interface IHistoryService {
	public History createOrUpdate(History history);
	public void delete(Long id);
	History getById (Long id) throws NoSuchElementException;
}
