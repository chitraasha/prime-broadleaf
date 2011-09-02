package org.primefaces.examples.moviecollector.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.NodeExpandEvent;
import org.primefaces.examples.moviecollector.domain.Category;
import org.primefaces.examples.moviecollector.service.CategoryService;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Component;

@Component("userBean")
@ViewScoped
public class UserBean implements Serializable {

	private List<String> groups;
	
	private JdbcUserDetailsManager userDetailsManager;

	@Autowired
	public UserBean(JdbcUserDetailsManager userDetailsManager) {
		this.userDetailsManager = userDetailsManager;
		setGroups(userDetailsManager.findAllGroups());

	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public List<String> getGroups() {
		return groups;
	}

}
