package com.howtodoinjava.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.hotodoinjava.utils.ConnectionPool;

@Path("/user-management")
public class UserManagementModule
{
	ConnectionPool cone ;
	@GET
	@Path("/users")
	public Response getAllUsers()
	{
		cone = new ConnectionPool();
		cone.conect();
		
		String result = "RESTful Application :" +cone.getLlegoAdb() + "is online";
		return Response.status(200).entity(result).build();
	}
}
