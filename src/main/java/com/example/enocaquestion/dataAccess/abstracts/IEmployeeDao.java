package com.example.enocaquestion.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.enocaquestion.entities.concretes.Employee;

public interface IEmployeeDao extends JpaRepository<Employee, Long>{

	List<Employee> findEmployeesByCompany_CompanyId(Long companyId);
	
}
