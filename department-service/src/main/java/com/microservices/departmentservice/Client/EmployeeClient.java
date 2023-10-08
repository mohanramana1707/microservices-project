package com.microservices.departmentservice.Client;

import java.util.List;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.microservices.departmentservice.Model.Employee;


//Declarative Client

@HttpExchange
public interface EmployeeClient {
	
	
	@GetExchange("/employee/department/{departmentId}")
	public List<Employee> findByDeptId(@PathVariable("departmentId") Long departmentId );
		
	
// we are just declaring that we have call the above url with deptid, the it should fetch list of exployee belongs to that dept by calling Employee WS.
//	
	

}
