package com.revature.app.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.banknew.model.EmployeeModel;

@Path("/employees")
public class EmployeeController {
	EmployeeDao dao = new EmployeeDaoImpl();
	ArrayList<EmployeeModel> employees  = new ArrayList<>();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		try {
			employees = dao.getemployeelist();
			return Response
					.ok()
					.entity(employees)
					.build();
		} catch (SQLException e) {
			return Response.status(500).build();
			
		}
		
		
	} 	 		
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("eid") int id) {
		try {
			employees = dao.getemployeelist();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return Response.ok().entity(employees).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(EmployeeModel employee) {
		System.out.println(employee);
		return Response.ok().build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(EmployeeModel employee) {
		System.out.println("PUT");
		System.out.println(employee);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		System.out.println("Employee ID to delete: " + id);
		return Response.ok().build();
	}

}