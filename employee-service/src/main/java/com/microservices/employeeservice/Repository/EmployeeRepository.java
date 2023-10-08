package com.microservices.employeeservice.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.microservices.employeeservice.Model.Employee;

@Repository
public class EmployeeRepository {
	
private List<Employee> employees= new ArrayList<>();
	

	public Employee addEmployee(Employee employee) {
		employees.add(employee);
		return employee;
	}
	

	public Employee findById(Long id) {
		return employees.stream()
				.filter(employee -> employee.id().equals(id))
				.findFirst()
				.orElseThrow();
										
	}
	
	public List<Employee> findAll(){
		return employees;
	}
	
	// finding emp by Depart id
	
	public List<Employee> findByDepartment(Long departmentId){
		return employees.stream()
				.filter(emp->emp.department_id().equals(departmentId))
				.toList();
		
	}

}
