package tn.esprit.spring.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.esprit.spring.entity.CategoriePublication;
import tn.esprit.spring.entity.History;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IHistoryRepository;
import tn.esprit.spring.service.IHistoryService;

@AllArgsConstructor
@Service
public class HistoryServiceImpl implements IHistoryService{

	private final IHistoryRepository historyRepository;
	@Override
	public History createOrUpdate(History history) {
		if (history.getId()!=null) 
		{
				getById(history.getId());
		}
		return historyRepository.save(history);
	}

	@Override
	public void delete(Long id) {
		
		historyRepository.deleteById(id);
	}

	@Override
	public History getById(Long id) throws NoSuchElementException {
		Optional<History> history = historyRepository.findById(id);
		if (history.isPresent()) return history.get();
		throw new NoSuchElementException();
	}

	
	@Override
	public Set<CategoriePublication> getUserFavCategories(User user) {
		List<History> histories = this.historyRepository.findFirst3ByUserIdOrderByRatingDesc(user.getId());
		return histories
				.stream()
				.map(history -> history.getPublication().getCategoriePublications())
				.collect(Collectors.toSet());
	}
	
	
	
	
}
