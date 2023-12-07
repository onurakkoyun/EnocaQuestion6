package com.example.enocaquestion.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enocaquestion.business.abstracts.IEmployeeService;
import com.example.enocaquestion.core.utilities.results.DataResult;
import com.example.enocaquestion.core.utilities.results.ErrorDataResult;
import com.example.enocaquestion.core.utilities.results.Result;
import com.example.enocaquestion.core.utilities.results.SuccessDataResult;
import com.example.enocaquestion.core.utilities.results.SuccessResult;
import com.example.enocaquestion.dataAccess.abstracts.IEmployeeDao;
import com.example.enocaquestion.entities.concretes.Employee;

@Service
public class EmployeeManager implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Employee added");
	}

	@Override
	public Result delete(Long employeeId) {
		this.employeeDao.deleteById(employeeId);
		return new SuccessResult("Employee deleted");
	}

	@Override
	public DataResult<List<Employee>> getAllEmployee() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}

	@Override
	public Result updateEmployee(Employee newEmployee) {
		Employee existingEmployee = employeeDao.findById(newEmployee.getEmployeeId()).orElse(null);

		existingEmployee.setFullname(newEmployee.getFullname());
		existingEmployee.setEmail(newEmployee.getEmail());
		existingEmployee.setPosition(newEmployee.getPosition());
		employeeDao.save(existingEmployee);

		return new SuccessResult("Employee updated successfully");
	}

	@Override
	public DataResult<List<Employee>> getEmployeesByCompanyId(Long companyId) {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findEmployeesByCompany_CompanyId(companyId),
				"Employees listed");
	}

	@Override
	public DataResult<Employee> getEmployeeById(Long employeeId) {
		Optional<Employee> optionalEmployee = employeeDao.findById(employeeId);

		if (optionalEmployee.isPresent()) {
			Employee existingEmployee = optionalEmployee.get();
			return new SuccessDataResult<Employee>(existingEmployee, "Employee listed by employeeId");
		} else {
			return new ErrorDataResult<>("No employee with employeeId was found");
		}
	}

}
