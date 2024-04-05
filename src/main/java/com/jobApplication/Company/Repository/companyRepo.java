package com.jobApplication.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobApplication.Company.Model.Company;



public interface companyRepo extends JpaRepository<Company, Long>{
}
