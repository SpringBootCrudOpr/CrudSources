package com.codedecode.basicmicroservicetest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.basicmicroservicetest.entity.Department;
import com.codedecode.basicmicroservicetest.error.DepartmentNotFoundException;
import com.codedecode.basicmicroservicetest.service.DepartmentService;



@RestController

public class DepartmentController {
	  
	private final Logger Log = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	// Sample Request Payload
	
	/*
	 * { "departmentName":"EEE", "departmentLocation":"Telangana",
	 * "departmentCode":"EEE01" }
	 */
	@PostMapping("/department")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		
		Log.info("Entered Into saveDepartment method");
		Log.debug("department"+department.getDepartmentId());
		
		return departmentService.saveDepartment(department);
		
	}
		
	@GetMapping("/department")
	public List<Department> department() {
		
		return departmentService.getAllDepartmentDetails();
		
	}
	
	@GetMapping("/department/{id}")
	public Department departmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		
		return departmentService.getDepartmentById(departmentId);
		
	}
	
	@DeleteMapping("/department/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		Log.info("Entered Into deleteDepartmentById method");
		Log.info("Entered Into deleteDepartmentById method Newly");
		Log.info("Entered Into deleteDepartmentById method Newly second time");
		Log.info("Entered Into deleteDepartmentById method Newly five time");
		Log.debug("departmentId::::"+departmentId);
		
		 departmentService.deleteDepartmentById(departmentId);
		 
		 return "Department Id delete successfully";
		
	}
		
	
	@PutMapping("/department/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId,department);
		
		
	}
	
	@GetMapping("/department/name/{name}/{id}")
	public Department departmentByName(@PathVariable("name") String departmentName,@PathVariable("id") Long departmentId) {
		
		return departmentService.getDepartmentByNameId(departmentName,departmentId);
		
	}

}
