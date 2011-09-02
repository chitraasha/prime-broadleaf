package org.primefaces.examples.moviecollector.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.examples.moviecollector.domain.Movie;
import org.primefaces.examples.moviecollector.service.MovieService;
import org.primefaces.examples.moviecollector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("createUser")
@Scope("request")
public class CreateUser implements Serializable{
 
	public CreateUser() {}
	
	private UserService userService;
	
	private String userName;
	
	private String password;
	
	private String groupName;
	
	private String groupId;
	
	@Autowired
	public CreateUser(UserService userService) {
		this.userService = userService;
	}
	
	public void save(ActionEvent actionEvent) {
		userService.createNewUser(this.userName, this.password, this.groupName);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "User is saved");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}
}