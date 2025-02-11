package com.revature.bankapp.controller;

import java.sql.SQLException;
import java.util.ArrayList;

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

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.banknew.model.Customer;

@Path("/customers")
public class CustomerController {
	CustomerDao dao = new CustomerDaoImpl();
	private static Customer currentCustomer;
	public static Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public static void setCurrentCustomer(Customer currentCustomer) {
		CustomerController.currentCustomer = currentCustomer;
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@GET
	@Path("/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginDetails(@PathParam("email") String email, @PathParam("password") String password) {
		LOGGER.info("Start");

		try {
			Customer customer = new Customer();
			customer = dao.getLoginDetails(email);
			if (customer == null) {
				LOGGER.info("Invalid Password or Email");
				return Response.status(401).build();
			} else if (customer.getPassword().equals(password)) {
				LOGGER.info("Login Successful");
				LOGGER.debug("{}", customer);
				CustomerController.setCurrentCustomer(customer);
				return Response.ok().entity(customer).build();
			} else {
				LOGGER.info("Invalid Password or Email");
				return Response.status(401).build();
			}
		} catch (AppException e) {
			return Response.status(500).build();

		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)

	public Response createCustomer(Customer customer) {
		LOGGER.info("Start");
		LOGGER.debug("{}", customer);

		try {

			dao.create(customer);
			LOGGER.info("End");
			return Response.ok().build();
		}

		catch (AppException e) {
			return Response.status(500).build();

		}
	}

}
