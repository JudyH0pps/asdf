package com.ssafy.camp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.camp.model.dto.User;
import com.ssafy.camp.model.service.CampService;
import com.ssafy.camp.model.service.UserService;

@Controller
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	CampService campService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		User loginUser = userService.getUserByUserId(user.getUserId());
		if (user != null && user.getPassword().equals(loginUser.getPassword())) {
			return new ResponseEntity<User>(loginUser, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Fail", HttpStatus.NOT_FOUND);
	}

	@GetMapping("")
	public ResponseEntity<?> getAllUsers() {
		List<User> userList = userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		int result = userService.insertUser(user);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@PostMapping("/{userKey}/like/{campKey}")
	public ResponseEntity<?> userLikeCamp(@PathVariable String userKey, @PathVariable String campKey) {
		int result = userService.likeCamp(userKey, campKey);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("/{userKey}/like/{campKey}")
	public ResponseEntity<?> dislikeCamp(@PathVariable String userKey, @PathVariable String campKey) {
		int result = userService.dislikeCamp(userKey, campKey);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{userKey}/like")
	public ResponseEntity<?> getLikesByUser(@PathVariable String userKey) {
		List<Integer> likeList = userService.getLikesByUser(userKey);
		return new ResponseEntity<List<Integer>>(likeList, HttpStatus.OK);
	}
}
