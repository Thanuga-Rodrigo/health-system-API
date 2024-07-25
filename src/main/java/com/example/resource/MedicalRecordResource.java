/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;
import com.example.dao.MedicalRecordDAO;
import com.example.model.MedicalRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Resource class for managing medical record information.
 * @author Laptop Outlet
 */
@Path("/medicalRecords")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalRecordResource {
     private final MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();
    private static final Logger LOGGER = Logger.getLogger(MedicalRecordResource.class.getName());
//Retrieve the list of all medical records.
    @GET
    @Path("/medicalRecordList")
    public List<MedicalRecord> getMedicalRecordList() {
        try {
            return medicalRecordDAO.getMedicalRecordList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving list of medical records.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Add a new medical record to the system.
    @POST
    @Path("/addMedicalRecord")
    public Response addMedicalRecord(MedicalRecord medicalRecord) {
        try {
            String message = medicalRecordDAO.addMedicalRecord(medicalRecord);
            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding medical record.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Update an existing medical record with new information.
    @PUT
    @Path("/{id}")
    public Response updateMedicalRecord(@PathParam("id") int id, MedicalRecord medicalRecord) {
        try {
            String message = medicalRecordDAO.updateMedicalRecord(id, medicalRecord);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating medical record.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
// Delete a medical record from the system.
    @DELETE
    @Path("/{id}")
    public Response deleteMedicalRecord(@PathParam("id") int id) {
        try {
            String message = medicalRecordDAO.deleteMedicalRecord(id);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting medical record.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    //Get details of a medical record by its ID.
    @GET
    @Path("/{id}")
    public Response getMedicalRecordById(@PathParam("id") int id) {
        try {
            String details = medicalRecordDAO.getMedicalRecordById(id);
            return Response.status(Response.Status.OK).entity(details).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching medical record details.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
