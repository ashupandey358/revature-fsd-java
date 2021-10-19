package com.revature.bankapp.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.TransctionDao;
import com.revature.bankapp.dao.impl.TransctionDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.banknew.model.Account;
import com.revature.banknew.model.Transction;

@Path("/transctions")
public class TransctionController {
	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransctionController.class);
	TransctionDao dao = new TransctionDaoImpl();
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response withdrawal(Transction transction) {
		
		int currentBalance = 0;
		LOGGER.info("Withdrwal method Start");
		LOGGER.debug("{}", transction);
		try {
			currentBalance = dao.currentAmount(transction.getAccountNumber());
		} catch (AppException e) {
			
			e.printStackTrace();
			return Response.status(500).build();
		}
		if(currentBalance<transction.getAmount())
		{
			LOGGER.info("insufficient funds");
			return Response.status(400).build();
		}
		else {
			int updatedbalance = currentBalance - transction.getAmount();
			try {
				dao.forWithdrawal(updatedbalance, transction.getAccountNumber());
				dao.transctionCreate(transction.getAccountNumber(),"W",transction.getAmount());
				return Response.status(200).build();
			} catch (AppException e) {
				LOGGER.info(" Performing withdrawal failed");
				e.printStackTrace();
				return Response.status(500).build();
			}
		}
	}
		
		
		@PUT
		@Path("/deposit")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response deposit(Transction transction) {
			
			int currentBalance = 0;
			LOGGER.info("Withdrwal method Start");
			LOGGER.debug("{}", transction);
			try {
				currentBalance = dao.currentAmount(transction.getAccountNumber());
			} catch (AppException e) {
				
				e.printStackTrace();
				return Response.status(500).build();
			}
			
				
				try {
					int updatedbalance = currentBalance + transction.getAmount();
				    dao.forDeposite(updatedbalance, transction.getAccountNumber());
					dao.transctionCreate(transction.getAccountNumber(),"D",transction.getAmount());
					return Response.status(200).build();
				} catch (AppException e) {
					LOGGER.info(" Performing Deposit failed");
					e.printStackTrace();
					return Response.status(500).build();
				}
			}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getTransactions(Transction transction) {
			LOGGER.info("Transactions method called");
			LOGGER.debug("{}", transction);
			try {
				List<Transction> transactionList = dao.viewTransctionforSpecificAccount(transction.getAccountNumber());
				LOGGER.info("Transaction got successfuly");
				return Response.ok().entity(transactionList).build();
			} catch (AppException e) {
				LOGGER.info("Showing transactions failed");
				e.printStackTrace();
				return Response.status(500).build();
			}

		}
	     
		
		
		
	}
	
	
	
	
	


