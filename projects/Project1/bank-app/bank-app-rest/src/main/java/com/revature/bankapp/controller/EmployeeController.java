package com.revature.bankapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.dao.impl.TransctionDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.banknew.model.Account;
import com.revature.banknew.model.Customer;
import com.revature.banknew.model.Employee;
import com.revature.banknew.model.Transction;

@Path("/employees")
public class EmployeeController {

	EmployeeDao dao = new EmployeeDaoImpl();
	CustomerDaoImpl dao1 = new CustomerDaoImpl();
	TransctionDaoImpl dao2 = new TransctionDaoImpl();

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)

	public Response createCustomer(Employee employee) {
		LOGGER.info("Start");
		LOGGER.debug("{}", employee);

		try {
			dao.create(employee);
			LOGGER.info("End");
			return Response.ok().build();
		} catch (AppException e) {

			return Response.status(500).build();

		}
	}

	@GET
	@Path("/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginDetails(@PathParam("email") String email, @PathParam("password") String password) {
		LOGGER.info("Start");

		try {
			
			Employee employee = new Employee();
			employee = dao.getLoginDetails(email);
			if (employee == null) {
				LOGGER.info("Invalid Password or Email");
				return Response.status(401).build();
			} else if (employee.getPassword().equals(password)) {
				LOGGER.info("Login Successful");
				LOGGER.debug("{}", employee);
				return Response.ok().entity(employee).build();
			} else {
				LOGGER.info("Invalid Password or Email");
				return Response.status(401).build();
			}
		} catch (AppException e) {
			return Response.status(500).build();

		}

	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountDetails(@PathParam("id") int id)
	{
		LOGGER.info("Start");
		ArrayList<Account> accountdetail = new ArrayList<>();
		
		try {
			accountdetail = dao1.getaccountDetails(id);
			LOGGER.info("Get Account details ");
			LOGGER.debug("{}", accountdetail);
			return Response.ok().entity(accountdetail).build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
		
	}
	
	
}
