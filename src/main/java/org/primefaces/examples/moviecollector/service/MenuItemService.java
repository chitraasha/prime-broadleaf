package org.primefaces.examples.moviecollector.service;

import java.util.List;

import org.primefaces.examples.moviecollector.domain.MenuItem;
import org.primefaces.examples.moviecollector.domain.Movie;

public interface MenuItemService {

	public void createNew(MenuItem menuItem);
	
	public List<MenuItem> findAll();
	
	public List<MenuItem> findByHeadline(String title);
	
	public void update(MenuItem menuItem);
	
	public void remove(MenuItem menuItem);
	
	public MenuItem findById(Long id);
}
