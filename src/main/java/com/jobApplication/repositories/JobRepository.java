package com.jobApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobApplication.Model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
