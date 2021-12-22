package com.codedecode.basicmicroservicetest.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.codedecode.basicmicroservicetest.entity.Department;
import com.codedecode.basicmicroservicetest.error.DepartmentNotFoundException;
import com.codedecode.basicmicroservicetest.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository departmentRepo;

	@Override
	public List<Department> getAllDepartmentDetails() {
		
		return departmentRepo.findAll();
		
	}

	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepo.save(department);
		
	}

	@Override
	public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		
		 Department dept =departmentRepo.findById(departmentId).
				 orElseThrow(() -> new DepartmentNotFoundException ("Entered Department ID not present is ::::"+departmentId));
		 return departmentRepo.findById(departmentId).get();
		 
			/*
			 * if(!dept.isPresent()) { throw new DepartmentNotFound
			 * ("Entered Department is not available"); }else {
			 * 
			 * return dept.get(); }
			 */
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department dept = departmentRepo.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()) && !"null".equalsIgnoreCase(department.getDepartmentName())) {
			dept.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentLocation()) && !"".equalsIgnoreCase(department.getDepartmentLocation())&& !"null".equalsIgnoreCase(department.getDepartmentLocation())) {
			dept.setDepartmentLocation(department.getDepartmentLocation());
		}
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())&& !"null".equalsIgnoreCase(department.getDepartmentCode())) {
			dept.setDepartmentCode(department.getDepartmentCode());
		}
		
		return departmentRepo.save(dept);
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		
		departmentRepo.deleteById(departmentId);
		
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		
		//return departmentRepo.findByDepartmentName(departmentName);
		//return departmentRepo.findByDepartmentNameIgnoreCase(departmentName);
		return departmentRepo.findByDepartmentNameIgnoreCase(departmentName);
	}
	@Override
	public Department getDepartmentByNameId(String departmentName,Long departmentId) {
		
		//return departmentRepo.findByDepartmentName(departmentName);
		//return departmentRepo.findByDepartmentNameIgnoreCase(departmentName);
		return departmentRepo.getDepartmentNameID(departmentName,departmentId);
	}
	
	

	

}
