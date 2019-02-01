package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.buisness.BuisnessRules;

@Path("/classroom")
public class Endpoints {

	@Inject
	BuisnessRules repo;

	@Path("/getAllClassrooms")
	@GET
	@Produces("application/json")
	public String getAllClassrooms() {

		return repo.getAllClassrooms();

	}

	@Path("/createClassroom")
	@POST
	@Produces("application/json")
	public String createClassroom(String classroom) {

		return repo.createClassroom(classroom);

	}

	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	public String deleteClassroom(@PathParam("id") Long id) {

		return repo.deleteClassroom(id);

	}

	@Path("/{id}")
	@PUT
	@Produces("application/json")
	public String updateClassroom(@PathParam("id") Long id, String classroom) {

		return repo.updateClassroom(id, classroom);

	}

}
