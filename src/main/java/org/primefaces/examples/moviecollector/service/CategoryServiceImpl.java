package org.primefaces.examples.moviecollector.service;

import java.util.List;

import org.primefaces.examples.moviecollector.dao.CategoryDAO;
import org.primefaces.examples.moviecollector.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

	private CategoryDAO categoryDAO;
	
	@Autowired
	public CategoryServiceImpl(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	@Transactional
	public void createNew(Category category) {
		categoryDAO.persist(category);
	}

	@Transactional(readOnly=true)
	public List<Category> findAll() {
		return categoryDAO.loadAll();
	}

	@Transactional(readOnly=true)
	public List<Category> findByName(String name) {
		return categoryDAO.findByName(name);
	}

	@Transactional
	public void update(Category category) {
		categoryDAO.update(category);
	}
	
	@Transactional
	public void remove(Category category) {
		categoryDAO.delete(category);
	}

	@Transactional(readOnly=true)
	public Category findById(Long id) {
		return categoryDAO.loadById(id);
	}

	@Override
	public List<Category> findAllParents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findChildren(Category category) {
		// TODO Auto-generated method stub
		return null;
	}


}