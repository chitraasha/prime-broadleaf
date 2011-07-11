package org.primefaces.examples.moviecollector.dao;

import java.util.List;

import org.primefaces.examples.moviecollector.domain.Category;

public interface CategoryDAO {

	Category loadById(Long id);
	
	void persist(Category category);
	
	void update(Category category);
	
	void delete(Category category);
	
	List<Category> loadAll();
	
	public List<Category> findByName(String name);
}
