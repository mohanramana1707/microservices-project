package com.microservices.departmentservice.Controller;


import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.departmentservice.Client.EmployeeClient;
import com.microservices.departmentservice.Model.Department;
import com.microservices.departmentservice.Repository.DepartementRepository;


@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private static final org.slf4j.Logger logger= LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartementRepository departmentRepo;
	
	//EmployeeClient is a INterface ,when we call this , a BEAN will be created which should call the Employee Service.(for this we did a config in WebClinetConfig class)
	@Autowired  
	private EmployeeClient employeeClient;
	
	@PostMapping("/add")
	public Department add(@RequestBody Department dept) {
		logger.info("Department add:{} ",dept);
		return departmentRepo.addDepartment(dept);
	}
	
	@GetMapping("/getAll")
	public List<Department> getAll(){
		logger.info("Department find:{} ");
		return departmentRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable Long id) {
		logger.info("Department findbyId:{} ",id);
		return departmentRepo.findById(id);
	}
	
	
	// MS call to Employee Service
	@GetMapping("/getAllWithEmployee")
	public List<Department> findAllWithEmployees(){
		logger.info("Department with employees find:{} ");
		List<Department> departments= departmentRepo.findAll();
		
		// for each department, we are adding all the employees to the employeeList  who are belong to the department using the EMPLOYEE-SERVICE
		
		departments.forEach(
				department -> department.setEmployees(
						employeeClient.findByDeptId(department.getId()))
				);
		return departments;
	}
	
}
