/**
 * 
 */
package com.example.demo;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author HP
 *
 */
public interface UserService {

	public List<Login> getAllUsers();

	public void deleteUser(long id);

	public Login saveUser(Login user);

	public Login findUserByEmail(String email);

	User loadUserByUsername(String username) throws UsernameNotFoundException;

	Login getLoggedInUser();

	String getLoggedInUserRole();
}
