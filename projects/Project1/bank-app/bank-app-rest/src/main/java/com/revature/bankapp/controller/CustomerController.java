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
import com.revature.banknew.model.Account;
import com.revature.banknew.model.Customer;

@Path("/customers")
public class CustomerController {
	CustomerDao dao = new CustomerDaoImpl();
	ArrayList<Account> account = new ArrayList<>();
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@GET
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginDetails(@PathParam("email") String email) {
		LOGGER.info("Start");
		LOGGER.debug("{}", email);
		try {
			Customer customer = new Customer();
			customer = dao.getLoginDetails(email);
			return Response.ok().entity(customer).build();
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

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addaccount")
	public Response createAccount(Account account) {
		LOGGER.info("Start");
		LOGGER.debug("{}", account);

		try {
			dao.account(account);

			LOGGER.info("End");
			return Response.ok().build();
		} catch (AppException e) {
			return Response.status(500).build();

		}

	}

	@GET
	@Path("/id")
	@Produces(MediaType.APPLICATION_JSON)

	public Response getListaccount(@PathParam("id") int id) {
		LOGGER.info("Start");
		LOGGER.debug("{}", id);

		try {
			dao.specficAccount(id);
			LOGGER.info("End");
			return Response.ok().entity(account).build();
		} catch (AppException e) {
			return Response.status(500).build();
		}

	}

}
