/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;
import com.example.dao.BillingDAO;
import com.example.model.Billing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Resource class for managing billing information.
 * @author Laptop Outlet
 */
@Path("/billings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BillingResource {
     private final BillingDAO billingDAO = new BillingDAO();
    private static final Logger LOGGER = Logger.getLogger(BillingResource.class.getName());
//Retrieve the list of all billing records.
    @GET
    @Path("/billingList")
    public List<Billing> getBillingList() {
        try {
            return billingDAO.getBillingList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving list of bills.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Add a new billing record to the system.
    @POST
    @Path("/addBilling")
    public Response addBill(Billing billing) {
        try {
            String message = billingDAO.addBill(billing);
            return Response.status(Response.Status.CREATED).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding bill.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Update an existing billing record with new information.
    @PUT
    @Path("/{id}")
    public Response updateBill(@PathParam("id") int id, Billing billing) {
        try {
            String message = billingDAO.updateBill(id, billing);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating bill.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
//Delete a billing record from the system.
    @DELETE
    @Path("/{id}")
    public Response deleteBill(@PathParam("id") int id) {
        try {
            String message = billingDAO.deleteBill(id);
            return Response.status(Response.Status.OK).entity(message).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting bill.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    //Find a billing record by its ID.
    @GET
    @Path("/{id}")
    public Response findBillById(@PathParam("id") int id) {
        try {
            String details = billingDAO.findBillById(id);
            return Response.status(Response.Status.OK).entity(details).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching bill details.", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
