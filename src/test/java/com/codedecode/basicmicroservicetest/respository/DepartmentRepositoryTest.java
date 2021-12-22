package com.codedecode.basicmicroservicetest.respository;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.codedecode.basicmicroservicetest.entity.Department;
import com.codedecode.basicmicroservicetest.repository.DepartmentRepository;

@DataJpaTest
public class DepartmentRepositoryTest {
	
	@Autowired
   private DepartmentRepository departmentRepository;
   
	@Autowired
	private TestEntityManager entityManager;
   
	
	@BeforeEach
	void setUp() {
		
		Department deptDetails = Department.builder().departmentName("IT")
				.departmentCode("IT001").departmentLocation("Bangalore").build();
		
		
		entityManager.persist(deptDetails);
	}
	
	@Test
	public void validateFindbyAllValuesTest() {
		
		Department dept = departmentRepository.findById(1L).get();
		
		assertEquals(dept.getDepartmentLocation(), "Bangalore");
		
		
	}

}
