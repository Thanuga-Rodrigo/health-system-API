/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;
import com.example.dao.DoctorDAO;
import com.example.model.Doctor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Resource class for managing doctor information.
 * @author Laptop Outlet
 */
@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorResource {
     private final DoctorDAO doctorDAO = new DoctorDAO();
    private static final Logger LOGGER = Logger.getLogger(DoctorResource.class.getName());
//Retrieve the list of all doctors.
    @GET
    @Path("/doctorList")
    public List<Doctor> getDoctorList() {
        try {
            return doctorDAO.getDoctorList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving list of doctors.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Add a new doctor to the system.
    @POST
    @Path("/addDoctor")
    public Response addDoctor(Doctor doctor) {
        try {
            String message = doctorDAO.addDoctor(doctor);
            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding doctor.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Update an existing doctor record with new information.
    @PUT
    @Path("/{id}")
    public Response updateDoctor(@PathParam("id") int id, Doctor doctor) {
        try {
            String message = doctorDAO.updateDoctor(id, doctor);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating doctor.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Delete a doctor record from the system.
    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") int id) {
        try {
            String message = doctorDAO.deleteDoctor(id);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting doctor.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    //Find a doctor record by its ID.
    @GET
    @Path("/{id}")
    public Response findDoctorById(@PathParam("id") int id) {
        try {
            String message = doctorDAO.findDoctorById(id);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while searching the doctor.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
