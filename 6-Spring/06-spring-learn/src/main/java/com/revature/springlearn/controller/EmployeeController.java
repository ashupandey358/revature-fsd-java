package com.revature.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.springlearn.model.Employee;
import com.revature.springlearn.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping
    public List<Employee> findByName(@RequestParam("name") String name) {
    	LOGGER.debug("Name: {}", name);
    	return employeeService.getByName(name);
    }

}
