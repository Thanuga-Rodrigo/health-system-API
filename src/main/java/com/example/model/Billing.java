/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author Laptop Outlet
 */
public class Billing {
    private int billId;
    private String patientName;
    private String invoices;
    private String payments;
    private String outstandingBal;
    
    public Billing() {
        // Default constructor
    }

    public Billing(int billId, String patientName, String invoices, String payments, String outstandingBal) {
        this.billId = billId;
        this.patientName = patientName;
        this.invoices = invoices;
        this.payments = payments;
        this.outstandingBal = outstandingBal;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getInvoices() {
        return invoices;
    }

    public void setInvoices(String invoices) {
        this.invoices = invoices;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public String getOutstandingBal() {
        return outstandingBal;
    }

    public void setOutstandingBal(String outstandingBal) {
        this.outstandingBal = outstandingBal;
    }
    
    
}
