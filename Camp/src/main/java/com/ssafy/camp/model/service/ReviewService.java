package com.ssafy.camp.model.service;

import java.util.List;

import com.ssafy.camp.model.dto.Camp;
import com.ssafy.camp.model.dto.Review;

public interface ReviewService {
	public int createReview(Review review);

	public int deleteReview(Review review);

	public int updateReview(Review review);

	public List<Review> getReviewList(Camp camp);
}
