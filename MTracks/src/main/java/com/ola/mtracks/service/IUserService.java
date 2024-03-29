package com.ola.mtracks.service;

import java.util.List;

import com.ola.mtracks.models.User;

public interface IUserService {
	
	User addUser(User user);
	User getUser(Long userId);
	User updateUser(User user);
	void deleteUser(Long userId);
	List<User> findAllUsers();
}
