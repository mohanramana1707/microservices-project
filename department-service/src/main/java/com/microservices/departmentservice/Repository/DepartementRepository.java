package com.microservices.departmentservice.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.microservices.departmentservice.Model.Department;

@Repository
public class DepartementRepository {
	
	private List<Department> departments= new ArrayList<>();
	
	public Department addDepartment(Department dept) {
		departments.add(dept);
		return dept;
	}
	
	public Department findById(Long id) {
		return departments.stream()
				.filter(dept -> dept.getId().equals(id))
				.findFirst()
				.orElseThrow();
							
				
	}
	
	public List<Department> findAll(){
		return departments;
	}
	

}
