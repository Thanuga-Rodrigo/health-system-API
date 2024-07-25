/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;
import com.example.dao.PrescriptionDAO;
import com.example.model.Prescription;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Resource class for managing prescriptions.
 * @author Laptop Outlet
 */

@Path("/prescriptions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrescriptionResource {
    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    private static final Logger LOGGER = Logger.getLogger(PrescriptionResource.class.getName());
//Retrieve the list of all prescriptions.
    @GET
    @Path("/prescriptionList")
    public List<Prescription> getPrescriptionList() {
        try {
            return prescriptionDAO.getPrescriptionList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving list of prescriptions.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Add a new prescription to the system.
    @POST
    @Path("/addPrescription")
    public Response addPrescription(Prescription prescription) {
        try {
            String message = prescriptionDAO.addPrescription(prescription);
            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding prescription.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Update an existing prescription with new information.
    @PUT
    @Path("/{id}")
    public Response updatePrescription(@PathParam("id") int id, Prescription prescription) {
        try {
            String message = prescriptionDAO.updatePrescription(id, prescription);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating prescription.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Delete a prescription from the system.
    @DELETE
    @Path("/{id}")
    public Response deletePrescription(@PathParam("id") int id) {
        try {
            String message = prescriptionDAO.deletePrescription(id);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting prescription.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    //Find a prescription by ID.
    @GET
    @Path("/{id}")
    public Response findPrescriptionById(@PathParam("id") int id) {
        try {
            String details = prescriptionDAO.findPrescriptionById(id);
            return Response.status(Response.Status.OK).entity(details).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching prescription details.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
