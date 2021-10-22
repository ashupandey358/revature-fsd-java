package com.revature.springlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.springlearn.model.Employee;
import com.revature.springlearn.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getByName(String name) {
		LOGGER.debug("Name: {}", name);
		return employeeRepository.findByName(name);
	}

}
