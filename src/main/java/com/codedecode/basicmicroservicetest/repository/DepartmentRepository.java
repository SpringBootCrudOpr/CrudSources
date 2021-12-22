package com.codedecode.basicmicroservicetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codedecode.basicmicroservicetest.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	public Department findByDepartmentName(String depatmentName);

	public Department findByDepartmentNameIgnoreCase(String depatmentName);
	
	@Query(value="Select * from DEPARTMENT where lower(department_Name)=lower(?1) and department_Id=?2", nativeQuery = true)
	public Department getDepartmentNameID(String depatmentName, Long id);
	
	
	

}
