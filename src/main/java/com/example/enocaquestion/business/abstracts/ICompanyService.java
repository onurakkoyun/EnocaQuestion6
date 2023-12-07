package com.example.enocaquestion.business.abstracts;

import java.util.List;


import com.example.enocaquestion.core.utilities.results.DataResult;
import com.example.enocaquestion.core.utilities.results.Result;
import com.example.enocaquestion.entities.concretes.Company;


public interface ICompanyService {
	
	Result add(Company company);
	
	Result delete(Long companyId);
	
	Result updateCompany(Company newCompany);
	
	DataResult<Company> getCompanyById(Long companyId);
	
	DataResult<List<Company>> getAllCompany();

}
