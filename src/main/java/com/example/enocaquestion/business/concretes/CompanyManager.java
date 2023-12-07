package com.example.enocaquestion.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enocaquestion.business.abstracts.ICompanyService;
import com.example.enocaquestion.core.utilities.results.DataResult;
import com.example.enocaquestion.core.utilities.results.ErrorDataResult;
import com.example.enocaquestion.core.utilities.results.Result;
import com.example.enocaquestion.core.utilities.results.SuccessDataResult;
import com.example.enocaquestion.dataAccess.abstracts.ICompanyDao;
import com.example.enocaquestion.entities.concretes.Company;
import com.example.enocaquestion.core.utilities.results.SuccessResult;

@Service
public class CompanyManager implements ICompanyService {

	@Autowired
	private ICompanyDao companyDao;

	@Override
	public Result add(Company company) {
		this.companyDao.save(company);
		return new SuccessResult("Company added");
	}

	@Override
	public Result delete(Long companyId) {
		this.companyDao.deleteById(companyId);
		return new SuccessResult("Company deleted");
	}

	@Override
	public DataResult<List<Company>> getAllCompany() {
		return new SuccessDataResult<List<Company>>(this.companyDao.findAll());
	}

	@Override
	public Result updateCompany(Company newCompany) {
		Company existingCompany = companyDao.findById(newCompany.getCompanyId()).orElse(null);

		existingCompany.setCompanyName(newCompany.getCompanyName());
		existingCompany.setWebsite(newCompany.getWebsite());
		existingCompany.setAddress(newCompany.getAddress());

		companyDao.save(existingCompany);

		return new SuccessResult("Company updated successfully");
	}

	@Override
	public DataResult<Company> getCompanyById(Long companyId) {
		Optional<Company> optionalCompany = companyDao.findById(companyId);

		if (optionalCompany.isPresent()) {
			Company existingCompany = optionalCompany.get();
			return new SuccessDataResult<Company>(existingCompany, "Company listed by companyId");
		} else {
			return new ErrorDataResult<>("No company with companyId was found");
		}
	}

}
