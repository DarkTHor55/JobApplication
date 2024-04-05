package com.jobApplication.Reviews.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobApplication.Company.Model.Company;
import com.jobApplication.Company.Service.companyService;
import com.jobApplication.Model.Job;
import com.jobApplication.Reviews.Model.Review;
import com.jobApplication.Reviews.Repository.reviewRepo;

@Service
public class reviewServiceImpl implements reviewService {
	@Autowired
	private reviewRepo reviewrepo;
	@Autowired
	private companyService compservice;

	int nexId;

	@Override
	public Boolean newReviews(Review review, Long c_id) {
		Company comp = compservice.getCompanyById(c_id);
		if (comp != null) {

			review.setCompany(comp);
			
			reviewrepo.save(review);
		}
		return true;

	}

	@Override
	public List<Review> getAllReviews(Long c_id) {
		return reviewrepo.findByCompanyId(c_id);

	}

	@Override
	public List<Review> getAll() {

		return reviewrepo.findAll();
	}

	@Override
	public Review deleteReview(Long id) {
		boolean a = false;
		for (Review rev : reviewrepo.findAll()) {
			if (id.equals(rev.getId())) {
				a = true;
				reviewrepo.deleteById(id);
				return rev;
			}
		}

		return null;
	}

	@Override
	public Review updateReview(Review review, Long c_id, Long r_id) {
		Company com = compservice.getCompanyById(c_id);
//		System.out.println(c_id+" company h ");
		Review rev = getReviewById(c_id, r_id);

		if (rev == null) {
			return null;
		} else {
			Long id = com.getId();

			deleteReview(rev.getId());
			review.setId(r_id);
			newReviews(review, c_id);
			return reviewrepo.save(review);

		}
	}

	@Override
	public Review getReviewById(Long C_id, Long r_id) {
		Company com = compservice.getCompanyById(C_id);
		List<Review> ls = com.getReview();
		for (Review review : ls) {
			System.out.println(review.getId());
		}
		for (Review rev : ls) {
			if (rev.getId() == r_id) {

				return rev;
			}
		}
		return null;
	}

}
