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

import com.example.enocaquestion.business.abstracts.IEmployeeService;
import com.example.enocaquestion.core.utilities.results.DataResult;
import com.example.enocaquestion.core.utilities.results.Result;
import com.example.enocaquestion.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody Employee employee){
		return ResponseEntity.ok(this.employeeService.add(employee));		
	}
	
	@DeleteMapping("/deleteByEmployeeId/{employeeId}")
	public Result deleteById(@PathVariable("employeeId") Long employeeId) {
		return this.employeeService.delete(employeeId);
	}
	
	@GetMapping("/getAllEmployees")
	public DataResult<List<Employee>> getAllEmployee() {
		return this.employeeService.getAllEmployee();
	}
	
	@GetMapping("/getEmployeesByCompanyId/{companyId}")
	public DataResult<List<Employee>> getEmployeesByCompanyId(@PathVariable Long companyId) {
		return this.employeeService.getEmployeesByCompanyId(companyId);
	}
	
	@GetMapping("/getEmployeeById/{employeeId}")
	public DataResult<Employee> getEmployeeById(@PathVariable Long employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	
	@PutMapping("/update/{employeId}")
	public Result updateEmployee(@RequestBody Employee newEmployee) {
		return this.employeeService.updateEmployee(newEmployee);
	}

}
