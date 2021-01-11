package com.eventapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventapp.entities.User;
import com.eventapp.repo.UserRepo;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepo userRepo;
	@Autowired

	public UserRepo getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	@Override
	public void addUser(User user) {
		userRepo.save(user);
		
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByusername(username);
	}

}