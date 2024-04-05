package com.jobApplication.Reviews.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobApplication.Reviews.Model.Review;

public interface reviewRepo extends JpaRepository<Review,Long> {
	List<Review> findByCompanyId(Long com_id);

}
