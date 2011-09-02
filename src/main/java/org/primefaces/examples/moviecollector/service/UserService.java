package org.primefaces.examples.moviecollector.service;

import java.util.List;

import org.primefaces.examples.moviecollector.domain.Category;


public interface UserService {

	public void createNewUser(String userName, String password, String groupName);
	
//	public List<Category> findAll();
//	
//	public List<Category> findRootNodes();
//	
//	public List<Category> findChildren(Category category);
//	
//	public List<Category> findByName(String name);
//	
//	public void update(Category category);
//	
//	public void remove(Category category);
//	
//	public Category findById(Long id);
	
}
