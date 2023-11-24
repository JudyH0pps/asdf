package com.ssafy.camp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.camp.model.dao.ReviewDao;
import com.ssafy.camp.model.dto.Camp;
import com.ssafy.camp.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao reviewDao;

	@Override
	public int createReview(Review review) {
		return reviewDao.insertReview(review);
	}

	@Override
	public int deleteReview(Review review) {
		return reviewDao.deleteReview(review);
	}

	@Override
	public int updateReview(Review review) {
		return reviewDao.updateReview(review);
	}

	@Override
	public List<Review> getReviewList(Camp camp) {
		return reviewDao.selectReviewByCampId(camp.getId());
	}

}
