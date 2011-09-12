package org.primefaces.examples.moviecollector.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.primefaces.examples.moviecollector.domain.Movie;
import org.primefaces.examples.moviecollector.service.MovieService;
import org.primefaces.examples.moviecollector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("manageUsers")
@Scope("session")
public class ManageUsers implements Serializable{

	private List<UserDetails> users = new ArrayList<UserDetails>();
	
	private List<String> groups;
	
	private UserService userService;
	
	private String userName;
	
	private UserDetails user;

	public ManageUsers() {}

	@Autowired
	public ManageUsers(UserService userService) {
		this.userService = userService;
		this.groups = userService.getGroups();
	}

	
	public List<String> getUsersByUsername(String username) {
		List<UserDetails> foundUsers = userService.findByUsername(username);
		List<String> titles = new ArrayList<String>();
	
		for(UserDetails u : foundUsers)
			titles.add(u.getUsername());
		return titles;
	}
	
	public void search(ActionEvent actionEvent) {
		users = userService.findByUsername(userName);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public void setUsers(List<UserDetails> users) {
		this.users = users;
	}

	public List<UserDetails> getUsers() {
		return users;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public List<String> getGroups() {
		return groups;
	}
}