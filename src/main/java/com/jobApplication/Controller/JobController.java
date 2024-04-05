package com.jobApplication.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.jobApplication.services.impl.JobService;
import com.jobApplication.Model.Job;

@RestController
public class JobController {
	@Autowired
	private JobService jobservice;


	@GetMapping("/h")
	public String str() {
		return "testing..";
	}

	@GetMapping("/jobs")
	public List<Job> allJobs() {
		return jobservice.getAllJobs();
	}

	@GetMapping("/jobs/{job_id}")
	public Job getJobsById(@PathVariable("job_id") Long job_id) {
		System.out.println("yha hu");
		if (jobservice.getJobById(job_id) == null) {
			new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			jobservice.getJobById(job_id);
			new ResponseEntity<Job>(HttpStatus.OK);
		}
		return jobservice.getJobById(job_id);
	}

	@PostMapping("/Jobs")
	public String createJob(@RequestBody Job job) {
		
		jobservice.createuser(job);
		return "Jobs added successfully";

	}

	@DeleteMapping("/deljob/{id}")
	public String delteJob(@PathVariable Long id) {
		if (jobservice.deletejob(id) == null) {
			new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			return "Not exist";
		} else {
			jobservice.deletejob(id);
			new ResponseEntity<>(HttpStatus.OK);
			return "Deleted";
		}
	}
	@PutMapping("/updatejob")
	public String updateJob(@RequestBody Job job){
		if(jobservice.updatejob(job)==null) {
			 new ResponseEntity<Job>(HttpStatus.BAD_GATEWAY);
		}else {
			 new ResponseEntity<Job>(HttpStatus.ACCEPTED);
		}
		return "updated..'+";
	}
	
}
