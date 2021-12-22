package com.codedecode.basicmicroservicetest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codedecode.basicmicroservicetest.entity.Department;
import com.codedecode.basicmicroservicetest.error.DepartmentNotFoundException;


public interface DepartmentService {


	public List<Department> getAllDepartmentDetails();

	public Department saveDepartment(Department department);

	public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public Department updateDepartment(Long departmentId, Department department);

	public void deleteDepartmentById(Long departmentId);

	public Department getDepartmentByName(String departmentName);

	public Department getDepartmentByNameId(String departmentName,Long departmentId);
	
	
	

	

}
