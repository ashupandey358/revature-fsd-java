package com.revature.springlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.springlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e inner join fetch e.department left outer join fetch e.skillList where e.name = :name")

	List<Employee> findByName(String name);
}

