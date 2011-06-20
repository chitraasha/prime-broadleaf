package org.primefaces.examples.moviecollector.service;

import java.util.List;

import org.primefaces.examples.moviecollector.domain.Add;
import org.primefaces.examples.moviecollector.domain.Movie;

public interface AddService {

	public void createNew(Add Add);
	
	public List<Add> findAll();
	
	public List<Add> findByHeadline(String title);
	
	public void update(Add Add);
	
	public void remove(Add Add);
	
	public Add findById(Long id);
}
