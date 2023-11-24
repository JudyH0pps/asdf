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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.camp.model.dto.Camp;
import com.ssafy.camp.model.dto.Review;
import com.ssafy.camp.model.service.CampService;
import com.ssafy.camp.model.service.ReviewService;

@Controller
@RequestMapping("/api/review")
@CrossOrigin("*")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@Autowired
	CampService campService;

	@GetMapping("/{campId}")
	public ResponseEntity<?> getReviewList(@PathVariable int campId) {
		Camp camp = campService.getCamp(campId);
		List<Review> reviewList = reviewService.getReviewList(camp);
		return new ResponseEntity<List<Review>>(reviewList, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> postReview(@RequestBody Review review) {
		int result = reviewService.createReview(review);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<?> modifyReview(@RequestBody Review review) {
		int result = reviewService.updateReview(review);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<?> deleteReview(@RequestBody Review review) {
		int result = reviewService.deleteReview(review);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
