package com.jobApplication.Reviews.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobApplication.Reviews.Model.Review;
import com.jobApplication.Reviews.Service.reviewServiceImpl;

@RestController
@RequestMapping("/company")
public class reviewController {
	
	@Autowired
	private reviewServiceImpl reviewService;
	
	@GetMapping("/{C_id}/review")
	public ResponseEntity<List<Review>> gettAllReview(@PathVariable Long C_id){
		 
		 return new ResponseEntity<>(reviewService.getAllReviews(C_id),HttpStatus.OK);
	}
	@PostMapping("/{C_id}/review")
	public ResponseEntity<String> addReview(@PathVariable Long C_id,@RequestBody Review review) {
		Boolean s= reviewService.newReviews(review, C_id);
		if(s) {
			return new ResponseEntity<>("Review Added",HttpStatus.OK);

		}else {
			return new ResponseEntity<>("Company not Exist",HttpStatus.BAD_REQUEST);

		}
	}
	@GetMapping("/{C_id}/review/{r_id}")
	public Review getReviewById(@PathVariable Long C_id,@PathVariable Long r_id) {
		Review rev=reviewService.getReviewById(C_id, r_id);
		if(rev==null) {
			new ResponseEntity<>("No review ",HttpStatus.BAD_REQUEST);
			 return null;
			
		}else {
			new ResponseEntity<>(HttpStatus.OK);
			return rev;
		}
	}
	@GetMapping("/")
	public List<Review> getAll(){
		System.out.println("agya yha");
		return reviewService.getAll();
	
		
	}
	@DeleteMapping("/{r_id}")
	public String deleteReview(@PathVariable Long r_id) {
		if(reviewService.deleteReview(r_id)==null) {
			return "Not exists";
		}else {
			reviewService.deleteReview(r_id);
			return "Deleted";
		}
	}
	@PutMapping("/{c_id}/review/{r_id}") 
	public ResponseEntity<?>updateReview(@RequestBody Review review,@PathVariable Long c_id,@PathVariable Long r_id){
		if (reviewService.updateReview(review, c_id, r_id)==null) {
			return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>("updated..",HttpStatus.OK);
		}
	}

}
