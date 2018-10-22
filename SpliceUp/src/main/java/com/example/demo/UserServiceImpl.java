/**
 * 
 */
package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

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
	public List<Login> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(long id) {
		userRepo.deleteById(id);
	}

	@Override
	@Transactional
	public Login saveUser(Login user) {
		return userRepo.save(user);
	}

}
