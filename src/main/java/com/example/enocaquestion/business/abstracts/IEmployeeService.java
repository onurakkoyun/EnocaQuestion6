package com.example.enocaquestion.business.abstracts;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.enocaquestion.core.utilities.results.DataResult;
import com.example.enocaquestion.core.utilities.results.Result;
import com.example.enocaquestion.entities.concretes.Employee;

public interface IEmployeeService {

	Result add(Employee employee);
	
	Result delete(Long employeeId);
	
	Result updateEmployee(Employee newEmployee);
	
	DataResult<List<Employee>> getAllEmployee();
	
	DataResult<Employee> getEmployeeById(Long employeeId);
	
	DataResult<List<Employee>> getEmployeesByCompanyId(@Param("companyId") Long companyId);
}
