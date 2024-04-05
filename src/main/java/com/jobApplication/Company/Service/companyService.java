package com.jobApplication.Company.Service;

import java.util.List;

import com.jobApplication.Company.Model.Company;





public interface companyService {
	 Company newCompanies(Company company);
		List<Company> getAllCompany();
		Company getCompanyById(Long id);
		Company deleteCompany(Long id);
		Company updateCompany(Company company);
		
}
