package org.primefaces.examples.moviecollector.service;

import java.util.List;

import org.primefaces.examples.moviecollector.custom.CustomUserDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.GroupManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService{

	
	
	@Autowired
	public UserServiceImpl(CustomUserDetailsManager customUserDetailsManager, @Qualifier("primeUserDetailsManager") GroupManager groupManager) {
		this.customUserDetailsManager = customUserDetailsManager;
		this.groupManager = groupManager;
	}
	
	private GroupManager groupManager;
	
	private CustomUserDetailsManager customUserDetailsManager;
	
	@Transactional
	public void createNewUser(String userName, String password, String groupName) {
		User user = new User(userName, password, true, true, true, true, AuthorityUtils.NO_AUTHORITIES); 
		customUserDetailsManager.createUser(user);
		groupManager.addUserToGroup(userName, groupName);
	}

	@Override
	public List<UserDetails> findAll() {
		return customUserDetailsManager.findAllUsers();
	}

	@Override
	public List<UserDetails> findByUsername(String userName) {
		return customUserDetailsManager.loadUsersByUsername(userName);
	}

	public List<String> getGroups() {
		return groupManager.findAllGroups();
	}
	
}