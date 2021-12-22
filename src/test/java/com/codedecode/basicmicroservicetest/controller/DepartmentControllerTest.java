package com.codedecode.basicmicroservicetest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.codedecode.basicmicroservicetest.controller.DepartmentController;
import com.codedecode.basicmicroservicetest.entity.Department;
import com.codedecode.basicmicroservicetest.error.DepartmentNotFoundException;
import com.codedecode.basicmicroservicetest.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {
	
	@Autowired
	 private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;

	@BeforeEach
	void setUp() {
		
		  department = Department.builder().departmentName("IT")
					.departmentCode("IT001").departmentLocation("Bangalore").departmentId(1L).build();
		 
		 	
	}
	
	@Test
	public void saveDepartment() throws Exception {
		
		Department inputDept =  Department.builder().departmentName("IT")
				.departmentCode("IT001").departmentLocation("Bangalore").build();
		
		Mockito.when(departmentService.saveDepartment(inputDept)).thenReturn(department);
		
		mockMvc.perform(post("/department")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "     \"departmentName\":\"IT\",\r\n"
						+ "     \"departmentLocation\":\"Bangalore\", \r\n"
						+ "     \"departmentCode\":\"IT001\"\r\n"
						+ "}")).andExpect(status().isOk());
		
	}
	
	@Test
   public void fetchDepartmentById() throws DepartmentNotFoundException,Exception {
		
		Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);
		
		mockMvc.perform(get("/department/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
		
	}

}
