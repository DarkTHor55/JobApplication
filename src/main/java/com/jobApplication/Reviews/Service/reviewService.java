package com.jobApplication.Reviews.Service;

import java.util.List;

import com.jobApplication.Reviews.Model.Review;

public interface reviewService {
	Boolean newReviews(Review review,Long C_id);
	List<Review> getAllReviews(Long id);
	Review getReviewById(Long C_id,Long r_d);
	List<Review>getAll();
	Review deleteReview(Long id);
	Review updateReview(Review review,Long c_id,Long r_id);

}
