package com.revature.bankapp.controller;

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
import com.revature.banknew.model.Account;
import com.revature.banknew.model.Customer;



@Path("/accounts")
public class AccounctController {
	
	CustomerDao dao = new CustomerDaoImpl();
	Customer customer = CustomerController.getCurrentCustomer();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccounctController.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAccount(Account account) {
		LOGGER.info("Start");
		LOGGER.debug("{}", account);
		int cust_id = CustomerController.getCurrentCustomer().getId();

		try {

			dao.createaccount(account,cust_id);
			LOGGER.info("Account inserted successfully");
			LOGGER.info("End");
			return Response.ok().build();
		}

		catch (AppException e) {
			return Response.status(500).build();

		}
	}
	@GET

	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountDetails()
	{
		LOGGER.info("Start");
		ArrayList<Account> accountdetail = new ArrayList<>();
		
		try {
			accountdetail = dao.getaccountDetails(customer.getId());
			LOGGER.info("Get Account details ");
			LOGGER.debug("{}", accountdetail);
			return Response.ok().entity(accountdetail).build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
		
	}
	

}
	

