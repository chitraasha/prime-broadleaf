package org.primefaces.examples.moviecollector.service;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.examples.moviecollector.dao.CategoryDAO;
import org.primefaces.examples.moviecollector.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private JdbcUserDetailsManager userDetailsManager;
	
	@Transactional
	public void createNewUser(String userName, String password, String groupName) {
		List<GrantedAuthority> col = new ArrayList<GrantedAuthority>();
		User user = new User(userName, password, true, true, true, true, col); 
		userDetailsManager.createUser(user);
		userDetailsManager.addUserToGroup(userName, groupName);
	}

//	@Transactional(readOnly=true)
//	public List<Category> findAll() {
//		return categoryDAO.loadAll();
//	}
//
//	@Transactional(readOnly=true)
//	public List<Category> findByName(String name) {
//		return categoryDAO.findByName(name);
//	}
//
//	@Transactional
//	public void update(Category category) {
//		categoryDAO.update(category);
//	}
//	
//	@Transactional
//	public void remove(Category category) {
//		categoryDAO.delete(category);
//	}
//
//	@Transactional(readOnly=true)
//	public Category findById(Long id) {
//		return categoryDAO.loadById(id);
//	}
//
//	@Transactional(readOnly=true)
//	public List<Category> findRootNodes() {
//		return categoryDAO.findRootNodes();
//	}
//
//	@Transactional(readOnly=true)
//	public List<Category> findChildren(Category category) {
//		return categoryDAO.findAllChildren(category);
//	}



}