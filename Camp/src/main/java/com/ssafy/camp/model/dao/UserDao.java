package com.ssafy.camp.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.camp.model.dto.User;

public interface UserDao {
	public List<User> selectAllUsers();
	
	public User getUserByUserId(String userId);

	public int insertUser(User user);

	public int userLikeCamp(Map<String, String> map);
	
	public int dislikeCamp(Map<String, String> map);
	
	public List<Integer> getLikesByUser(String userKey);
}
