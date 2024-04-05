package com.jobApplication.Company.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobApplication.Model.Job;
import com.jobApplication.Reviews.Model.Review;
import com.jobApplication.Reviews.Service.reviewService;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Company_table")
public class Company {
	@Id
	@Column(name="Company_id")
	private Long id;
	@Column(name ="Company_Name" )
	private String name;
	@Column(name ="Company_Description" )
	private String description;
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Job> jobs;
//	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Review>review;
	
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
	public Company() {
		super();
	}
	public Company(Long id, String name, String description, List<Job> jobs) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

}
