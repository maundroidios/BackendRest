package com.loreiro.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.loreiro.utils.ConnectionPool;
import com.loreiro.utils.ModuloBase;

@Path("/user-management")
public class UserManagementModule 
{

	ConnectionPool cone = ModuloBase.getConeBase();
	
	@GET
	@Path("/users")
	public Response getAllUsers()
	{
		String result = "RESTful Application :" +cone + "is online";
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/user")
	public Response getUsers(String userName)
	{
		String result = "RESTful Application :" +cone + "is online";
		return Response.status(200).entity(result).build();
	}
	
}
