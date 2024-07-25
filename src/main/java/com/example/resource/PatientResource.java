/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;
import com.example.dao.PatientDAO;
import com.example.model.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Resource class for managing patient information.
 * @author Laptop Outlet
 */

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource {
    private final PatientDAO patientDAO = new PatientDAO();
    private static final Logger LOGGER = Logger.getLogger(PatientResource.class.getName());
//Retrieve the list of all patients.
    @GET
    @Path("/patientList")
    public List<Patient> getAllPersons() {
        try {
            return patientDAO.getPatientList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving list of patients.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Add a new patient to the system.
    @POST
    @Path("/addPatient")
    public Response addPatient(Patient patient) {
        try {
            String message = patientDAO.addPatient(patient);
            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding patient.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Update an existing patient with new information.
    @PUT
    @Path("/{id}")
    public Response updatePerson(@PathParam("id") int id, Patient patient) {
        try {
            String message = patientDAO.updatePatient(id, patient);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating patient.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Delete a patient from the system.
    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") int id) {
        try {
            String message = patientDAO.deletePatient(id);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting patient.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    //Find a patient by ID.
    @GET
    @Path("/{id}")
    public Response findPatientById(@PathParam("id") int id) {
        try {
            String message = patientDAO.findPatientById(id);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while searching the patient.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
