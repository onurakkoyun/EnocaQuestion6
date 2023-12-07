package com.example.enocaquestion.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enocaquestion.business.abstracts.ICompanyService;
import com.example.enocaquestion.core.utilities.results.DataResult;
import com.example.enocaquestion.core.utilities.results.Result;
import com.example.enocaquestion.entities.concretes.Company;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController {
	
	@Autowired
	private ICompanyService companyService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody Company company){
		return ResponseEntity.ok(this.companyService.add(company));		
	}
	
	@DeleteMapping("/deleteByCompanyId/{companyId}")
	public Result deleteById(@PathVariable("companyId") Long companyId) {
		return this.companyService.delete(companyId);
	}
	
	@GetMapping("/getAllCompanies")
	public DataResult<List<Company>> getAllCompany() {
		return this.companyService.getAllCompany();
	}
	
	@GetMapping("/getCompanyById/{companyId}")
	public DataResult<Company> getCompanyById(@PathVariable Long companyId) {
		return companyService.getCompanyById(companyId);
	}
	
	@PutMapping("/update/{companyId}")
	public Result updateCompany(@RequestBody Company newCompany) {
		return this.companyService.updateCompany(newCompany);
	}

}
