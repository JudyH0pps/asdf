package com.ssafy.camp.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.camp.model.dao.UserDao;
import com.ssafy.camp.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public List<User> getAllUsers() {
		return userDao.selectAllUsers();
	}

	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	public int likeCamp(String userKey, String campKey) {
		Map<String, String> map = new HashMap<>();
		map.put("userKey", userKey);
		map.put("campKey", campKey);
		return userDao.userLikeCamp(map);
	}

	@Override
	public User getUserByUserId(String userId) {
		return userDao.getUserByUserId(userId);
	}

	@Override
	public List<Integer> getLikesByUser(String userKey) {
		return userDao.getLikesByUser(userKey);
	}

	@Override
	public int dislikeCamp(String userKey, String campKey) {
		Map<String, String> map = new HashMap<>();
		map.put("userKey", userKey);
		map.put("campKey", campKey);
		return userDao.dislikeCamp(map);
	}
}
