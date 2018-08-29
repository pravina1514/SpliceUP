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

	public List<UserMaster> getAllUsers();

	public void deleteUser(long id);

	public UserMaster saveUser(UserMaster user);
}
