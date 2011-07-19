package org.primefaces.examples.moviecollector.service;

import java.util.List;

import org.primefaces.examples.moviecollector.dao.MenuItemDAO;
import org.primefaces.examples.moviecollector.domain.MenuItem;
import org.primefaces.examples.moviecollector.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("menuItemService")
public class MenuItemServiceImpl implements MenuItemService{

	private MenuItemDAO menuItemDAO;
	
	@Autowired
	public MenuItemServiceImpl(MenuItemDAO menuItemDAO) {
		this.menuItemDAO = menuItemDAO;
	}
	
	@Transactional
	public void createNew(MenuItem menuItem) {
		menuItemDAO.persist(menuItem);
	}

	@Transactional(readOnly=true)
	public List<MenuItem> findAll() {
		return menuItemDAO.loadAll();
	}

	@Transactional(readOnly=true)
	public List<MenuItem> findByHeadline(String headLine) {
		return menuItemDAO.findByHeadline(headLine);
	}

	@Transactional
	public void update(MenuItem menuItem) {
		menuItemDAO.update(menuItem);
	}
	
	@Transactional
	public void remove(MenuItem menuItem) {
		menuItemDAO.delete(menuItem);
	}

	@Transactional(readOnly=true)
	public MenuItem findById(Long id) {
		return menuItemDAO.loadById(id);
	}
}