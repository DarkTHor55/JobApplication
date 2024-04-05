package com.jobApplication.Company.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobApplication.Company.Model.Company;
import com.jobApplication.Company.Service.companyServiceImpl;
import com.jobApplication.Model.Job;

@RestController
public class CompanyController {
	
	@Autowired
	private companyServiceImpl companyService;
	@GetMapping("/companies")
	public List<Company> getAllcom(){
		return companyService.getAllCompany();
	}

	@GetMapping("/companies/{id}")
	public Company getByid(@PathVariable Long id) {
		if(companyService.getCompanyById(id)==null) {
			new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			return null;
			
		}else {
			new ResponseEntity<>(HttpStatus.ACCEPTED);
			return companyService.getCompanyById(id);
		}
	}
	@DeleteMapping("/del/{id}")
	public String deleteCompany(@PathVariable Long id) {
		if(companyService.deleteCompany(id)==null) {
			new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
			return "Not exist";
		}else {
			companyService.deleteCompany(id);
			new ResponseEntity<Company>(HttpStatus.ACCEPTED);
			return "deleted";
	
		}
	}
	@PostMapping("/companies")
	public String createaCompony(@RequestBody Company company) {
		companyService.newCompanies(company);
		
		return "Creates..";
	}
	@PutMapping("/update/com")
	public String updateCompany(@RequestBody Company company) {
		if(companyService.updateCompany(company)==null) {
			 new ResponseEntity<Job>(HttpStatus.BAD_GATEWAY);
		}else {
			companyService.updateCompany(company);
			 new ResponseEntity<Job>(HttpStatus.ACCEPTED);
		}
//		companyService.updateCompany(company);
	
		return "updated";
	}
//	@GetMapping()
//	public ResponseEntity<List<Company>>getAllCompany(){
//		return new ResponseEntity<List<Company>>(HttpStatus.ok);
//	}
}
