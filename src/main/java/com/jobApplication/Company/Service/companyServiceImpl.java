package com.jobApplication.Company.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobApplication.Company.Model.Company;
import  com.jobApplication.Company.Repository.*;
import com.jobApplication.Model.Job;


@Service
public class companyServiceImpl implements companyService {
	@Autowired
	private companyRepo companyRepo;
	ArrayList<Long> list = new ArrayList<>();
	private int nexId;

	@Override
	public Company newCompanies(Company company) {
		List<Company> lastCheck = companyRepo.findAll();

		if ((list.size() >= 1)) {
			System.out.println("bda h ");
			System.out.println(list.size() + "size h yha ");
			Long i = list.remove(0);
			System.out.println("suru ka number " + i);
			company.setId(i);
			companyRepo.save(company);
		} else {
			nexId = lastCheck.size();
			System.out.println(nexId + " size  ");
			if(nexId>=1) {
				Company tempjob = lastCheck.get(nexId - 1);
				System.out.println(tempjob.getId());
				
				company.setId(tempjob.getId() + 1);
				
				companyRepo.save(company);
				
			}else {
				companyRepo.save(company);
				
			}
			
		}
	
		return null;
	}

	@Override
	public List<Company> getAllCompany() {
		
		return companyRepo.findAll();
	}

	@Override
	public Company getCompanyById(Long id) {
		for (Company i : getAllCompany()) {
			if(i.getId()==id) {
				return i;
			}
		}
		return null;
	}

	@Override
	public Company deleteCompany(Long id) {
		boolean a = false;
		for (Company com : getAllCompany()) {
			if (id.equals(com.getId())) {
				a = true;
				companyRepo.deleteById(id);
				return com;
			}
		}

		return null;
	}

	@Override
	public Company updateCompany(Company company) {
	
		boolean j = false;
		for (Company com : getAllCompany()) {
			Long a = com.getId();
			System.out.println(company.getId());
			if (a.equals(company.getId())) {
				System.out.println("upr");
				deleteCompany(a);
				j = true;
				System.out.println(company.getName());
				return companyRepo.save(company);
			}
		}
	
			return null;
		}
	


}
