package com.jobApplication.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobApplication.Company.Model.Company;
import com.jobApplication.Reviews.Model.Review;

import jakarta.persistence.*;

@Entity

public class Job {
	@Id
	@Column(name = "job_id")
	private long id;
	@Column(name = "Title")
	private String title;
	@Column(name = "Description")
	private String description;
	@Column(name = "Min_Salary")
	private String minSalary;
	@Column(name = "Max_salary")
	private String maxSalary;
	@Column(name = "Location")
	private String Location;

	@ManyToOne
	private Company company;
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(long id, String title, String description, String minSalary, String maxSalary, String location) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		Location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

}
