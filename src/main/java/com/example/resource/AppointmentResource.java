/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;
import com.example.dao.AppointmentDAO;
import com.example.model.Appointment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Resource class for managing appointment information.
 * @author Laptop Outlet
 */
@Path("/appointments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppointmentResource {
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();
    private static final Logger LOGGER = Logger.getLogger(AppointmentResource.class.getName());
//Retrieve the list of all appointments.
    @GET
    @Path("/appointmentList")
    public List<Appointment> getAppointmentList() {
        try {
            return appointmentDAO.getAppointmentList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving list of appointments.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Add a new appointment to the system.
    @POST
    @Path("/addAppointment")
    public Response addAppointment(Appointment appointment) {
        try {
            String message = appointmentDAO.addAppointment(appointment);
            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding appointment.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Update an existing appointment record with new information.
    @PUT
    @Path("/{id}")
    public Response updateAppointment(@PathParam("id") int id, Appointment appointment) {
        try {
            String message = appointmentDAO.updateAppointment(id, appointment);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating appointment.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Delete an appointment record from the system.
    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") int id) {
        try {
            String message = appointmentDAO.deleteAppointment(id);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting appointment.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    // Get details of a specific appointment by its ID.
    @GET
    @Path("/{id}")
    public Response getAppointmentDetails(@PathParam("id") int id) {
        try {
            String details = appointmentDAO.getAppointmentDetails(id);
            return Response.status(Response.Status.OK).entity(details).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching appointment details.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
