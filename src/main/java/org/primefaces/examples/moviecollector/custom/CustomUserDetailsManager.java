package org.primefaces.examples.moviecollector.custom;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;

public interface CustomUserDetailsManager extends UserDetailsManager {

	public List<UserDetails> loadUsersByUsername(String username);
	
	public List<UserDetails> findAllUsers();
	
}
