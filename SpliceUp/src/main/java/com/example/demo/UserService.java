/**
 * 
 */
package com.example.demo;

import java.util.List;

/**
 * @author HP
 *
 */
public interface UserService {

	public List<Login> getAllUsers();

	public void deleteUser(long id);

	public Login saveUser(Login user);
}
