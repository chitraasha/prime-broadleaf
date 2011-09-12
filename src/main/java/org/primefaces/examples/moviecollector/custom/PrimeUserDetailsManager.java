package org.primefaces.examples.moviecollector.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Repository;

@Repository
public class PrimeUserDetailsManager extends JdbcUserDetailsManager implements CustomUserDetailsManager {
	
	public static String CUSTOM_USERS_BY_USERNAME_QUERY = "select username,password,enabled from users where username like ?";  
	public static String FIND_ALL_USERS_QUERY = "select username,password,enabled from users";
	
	
	
	@Override
	public List<UserDetails> loadUsersByUsername(String username) {
		super.setUsersByUsernameQuery(CUSTOM_USERS_BY_USERNAME_QUERY);
		return super.loadUsersByUsername(username+"%");
	}

	@Override
	public List<UserDetails> findAllUsers() {
		return getJdbcTemplate().query(FIND_ALL_USERS_QUERY, new RowMapper<UserDetails>() {
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString(1);
                String password = rs.getString(2);
                boolean enabled = rs.getBoolean(3);
                return new User(username, password, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES);
            }

        });
		
	}
	
	
	
}
