package com.jobApplication.services;


import java.util.List;

import com.jobApplication.Model.Job;

public interface IJobService {
	
	
	public void createuser(Job job);	
	public  List<Job> getAllJobs();
	public Job getJobById(Long id);
	public Job updatejob(Job job);
	public Job deletejob(Long id);
	
	

}
