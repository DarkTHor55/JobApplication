package com.jobApplication.Reviews.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobApplication.Company.Model.Company;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Review {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Review_Id")
	private Long id;
	@Column(name="Review_Title")
	private String title;
	@Column(name="Review_Decription")
	private String description;
	@Column(name="Review_Rating")
	private double rating;
	@JsonIgnore
	@ManyToOne
	private Company company;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
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
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Review(Long id, String title, String description, double rating) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.rating = rating;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	} 
	

}
