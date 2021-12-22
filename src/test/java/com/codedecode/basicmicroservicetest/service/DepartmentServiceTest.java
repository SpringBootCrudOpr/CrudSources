package com.codedecode.basicmicroservicetest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.codedecode.basicmicroservicetest.entity.Department;
import com.codedecode.basicmicroservicetest.error.DepartmentNotFoundException;
import com.codedecode.basicmicroservicetest.repository.DepartmentRepository;
import com.codedecode.basicmicroservicetest.service.DepartmentService;

import static org.junit.Assert.*;

import java.util.Optional;	

@SpringBootTest
public class DepartmentServiceTest {
	
	@Autowired
	DepartmentService departmentService;
	
	@MockBean
	DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp() {
		
		Optional<Department> dept = Optional.of(Department.builder().departmentName("IT")
				.departmentCode("IT001").departmentLocation("Bangalore").departmentId(1L).build());
		
		Department deptDetails = Department.builder().departmentName("IT")
				.departmentCode("IT001").departmentLocation("Bangalore").build();
		
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(deptDetails);
		
		Mockito.when(departmentRepository.findById(1L)).thenReturn(dept);
	}
	
	@Test
	@DisplayName("Validating Department Name")
	public void validateDepartmentNameTest() {
		
		String deptName = "IT";
		
		Department deptFound = departmentService.getDepartmentByName(deptName);
		
		assertEquals(deptName, deptFound.getDepartmentName());
		
	}
	
	@Test
	@DisplayName("Validating Department Id")
	public void validateDepartmentIdTest() throws DepartmentNotFoundException {
		
		Long deptId = 1L;
		
		Department deptFound = departmentService.getDepartmentById(deptId);
		
		assertEquals(deptId, deptFound.getDepartmentId());
		
	}

}
