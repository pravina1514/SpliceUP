/**
 * 
 */
package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

	@Override
	@Transactional
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		Login user = userRepo.findByEmail(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserDetail().getRole()));

		return new User(user.getEmail(), user.getPassword(), grantedAuthorities);
	}

	@Override
	public Login getLoggedInUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof User) {
			username = ((User) principal).getUsername();
		} else {
			username = principal.toString();
		}
		return this.findUserByEmail(username);
	}

	@Override
	public String getLoggedInUserRole() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userRole = null;
		if (principal instanceof User) {
			userRole = ((User) principal).getAuthorities().iterator().next().getAuthority();
		} else {
			userRole = principal.toString();
		}
		return userRole;
	}

	@Override
	public Login findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

}
