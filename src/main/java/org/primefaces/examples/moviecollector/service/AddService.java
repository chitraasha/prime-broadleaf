package org.primefaces.examples.moviecollector.service;

import java.util.List;

import org.primefaces.examples.moviecollector.domain.Add;
import org.primefaces.examples.moviecollector.domain.Movie;

public interface AddService {

	public void createNew(Add add);
	
	public List<Add> findAll();
	
	public List<Add> findByHeadline(String title);
	
	public void update(Add add);
	
	public void remove(Add add);
	
	public Add findById(Long id);
}
