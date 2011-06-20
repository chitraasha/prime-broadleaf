package org.primefaces.examples.moviecollector.service;

import java.util.List;

import org.primefaces.examples.moviecollector.dao.AddDAO;
import org.primefaces.examples.moviecollector.domain.Add;
import org.primefaces.examples.moviecollector.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("addService")
public class AddServiceImpl implements AddService{

	private AddDAO addDAO;
	
	@Autowired
	public AddServiceImpl(AddDAO addDAO) {
		this.addDAO = addDAO;
	}
	
	@Transactional
	public void createNew(Add add) {
		addDAO.persist(add);
	}

	@Transactional(readOnly=true)
	public List<Add> findAll() {
		return addDAO.loadAll();
	}

	@Transactional(readOnly=true)
	public List<Add> findByHeadline(String headLine) {
		return addDAO.findByHeadline(headLine);
	}

	@Transactional
	public void update(Add add) {
		addDAO.update(add);
	}
	
	@Transactional
	public void remove(Add add) {
		addDAO.delete(add);
	}

	@Transactional(readOnly=true)
	public Add findById(Long id) {
		return addDAO.loadById(id);
	}
}