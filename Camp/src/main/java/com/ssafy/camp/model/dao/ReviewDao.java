package com.ssafy.camp.model.dao;

import java.util.List;

import com.ssafy.camp.model.dto.Camp;
import com.ssafy.camp.model.dto.Review;

public interface ReviewDao {
	public int insertReview(Review review);

	public List<Review> selectReviewByCampId(int campId);

	public int deleteReview(Review review);

	public int updateReview(Review review);
}
