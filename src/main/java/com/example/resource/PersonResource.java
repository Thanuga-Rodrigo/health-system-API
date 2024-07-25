/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.PersonDAO;
import com.example.model.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Resource class for managing person information.
 *
 * @author Laptop Outlet
 */

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonDAO personDAO = new PersonDAO();
    private static final Logger LOGGER = Logger.getLogger(PersonResource.class.getName());
//Retrieve the list of all persons.
    @GET
    @Path("/personList")
    public List<Person> getAllPersons() {
        try {
            return personDAO.getPersonList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving list of persons.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Add a new person to the system.
    @POST
    @Path("/addPerson")
    public Response addPerson(Person person) {
        try {
            String message = personDAO.addPerson(person);
            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding person.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Update an existing person with new information.
    @PUT
    @Path("/{id}")
    public Response updatePerson(@PathParam("id") int id, Person person) {
        try {
            String message = personDAO.updatePerson(id, person);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating person.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Delete a person from the system.
    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") int id) {
        try {
            String message = personDAO.deletePerson(id);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting person.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    //Find a person by ID.personList
    @GET
    @Path("/{id}")
    public Response findPersonById(@PathParam("id") int id) {
        try {
            String details = personDAO.findPersonById(id);
            return Response.status(Response.Status.OK).entity(details).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching person details.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}

