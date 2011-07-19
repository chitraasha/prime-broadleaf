package org.primefaces.examples.moviecollector.dao;

import java.util.List;

import org.primefaces.examples.moviecollector.domain.MenuItem;

public interface MenuItemDAO {

	MenuItem loadById(Long id);
	
	void persist(MenuItem menuItem);
	
	void update(MenuItem menuItem);
	
	void delete(MenuItem menuItem);
	
	List<MenuItem> loadAll();
	
	public List<MenuItem> findByHeadline(String headLine);
}
