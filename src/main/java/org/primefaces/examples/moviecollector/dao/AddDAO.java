package org.primefaces.examples.moviecollector.dao;

import java.util.List;

import org.primefaces.examples.moviecollector.domain.Add;

public interface AddDAO {

	Add loadById(Long id);
	
	void persist(Add Add);
	
	void update(Add Add);
	
	void delete(Add Add);
	
	List<Add> loadAll();
	
	public List<Add> findByHeadline(String headLine);
}
