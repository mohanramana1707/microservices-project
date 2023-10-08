package com.microservices.employeeservice.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.employeeservice.Model.Employee;
import com.microservices.employeeservice.Repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
private static final org.slf4j.Logger logger= LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@PostMapping("/add")
	public Employee add(@RequestBody Employee emp) {
		logger.info("Employee add:{} ",emp);
		return employeeRepo.addEmployee(emp);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAll(){
		logger.info("Employee find:{} ");
		return employeeRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		logger.info("Employee findbyId:{} ",id);
		return employeeRepo.findById(id);
	}
	
	@GetMapping("/department/{departmentId}")
	public List<Employee> findByDeptId(@PathVariable("departmentId") Long departmentId ) {
		logger.info("Employee findby Department Id:{} ",departmentId);
		return employeeRepo.findByDepartment(departmentId);
	}
	
	
	
	
	
	
	


	
}
