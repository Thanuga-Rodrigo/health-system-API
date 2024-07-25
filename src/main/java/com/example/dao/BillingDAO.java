/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Billing;
import java.util.ArrayList;

/**
 *
 * @author Laptop Outlet
 */
public class BillingDAO {
    
    // Static list to store billing records

    private static ArrayList<Billing> billingList = new ArrayList<>();
    
    // Static initialization block to add sample data

    static {
        billingList.add(new Billing(1, "Thanuga", "inv1", "5000", "25000"));
        billingList.add(new Billing(2, "Niketh", "inv2", "25000", "70000"));
        billingList.add(new Billing(3, "Kavindu", "inv3", "200", "10000"));
    }
    //Retrieve the list of all billing records.
    public ArrayList<Billing> getBillingList() {
        return billingList;
    }
    // Add a new billing record to the system.
    public String addBill(Billing billing) {
        int nextId;
        if(billingList.isEmpty()) {
            nextId = 1; 
        } else {
            nextId = billingList.get(billingList.size() - 1).getBillId() + 1;
        }
        billing.setBillId(nextId);
        billingList.add(billing);
        return "Bill of patient " + billing.getPatientName() + " has been added to the system successfully";
    }
    //Update an existing billing record with new information.
    public String updateBill(int Id, Billing updatedBilling){
        for(Billing billing : billingList){
            if(billing.getBillId() ==  Id){
                billing.setPatientName(updatedBilling.getPatientName());
                billing.setInvoices(updatedBilling.getInvoices());
                billing.setOutstandingBal(updatedBilling.getOutstandingBal());
                billing.setPayments(updatedBilling.getPayments());
                return "Bill - " + Id + "details updated successfully!";
            }
        }
        return "Bill under ID - " + Id + " not found!";
    }
    //Delete a billing record from the system.
    public String deleteBill(int Id){
        for (Billing billing : billingList){
            if(billing.getBillId() == Id){
                billingList.remove(billing);
                return "Bill of patient " + billing.getPatientName() + " removed successfully from the system!";
            }
        }
        return "Bill under ID - " + Id + " not found!";
    }
    //Find a billing record by its ID and retrieve its details.
    public String findBillById(int userId){
        for(Billing billing : billingList){
            if(billing.getBillId() == userId){
                return "Bill ID - " + billing.getBillId() +
                "\nPatient Name - " + billing.getPatientName() +
                "\nInvoice - " + billing.getInvoices() + 
                "\nOutstanding amount - " + billing.getOutstandingBal() + 
                "\nPaid Amount - " + billing.getPayments();
            }
        }
        return "Bill on ID - " + userId + " not found !";
    }
}
