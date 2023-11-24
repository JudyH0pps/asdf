package com.ssafy.camp.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.camp.model.dto.User;

public interface UserService {
	public List<User> getAllUsers();

	public int insertUser(User user);

	public int likeCamp(String userKey, String campKey);
	
	public int dislikeCamp(String userKey, String campKey);
	
	public User getUserByUserId(String userId);
	
	public List<Integer> getLikesByUser(String userKey);
}
