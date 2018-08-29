/**
 * 
 */
package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HP
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMasterRepository userRepo;

	@Override
	public List<UserMaster> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(long id) {
		userRepo.deleteById(id);
	}

	@Override
	public UserMaster saveUser(UserMaster user) {
		return userRepo.save(user);
	}

}
