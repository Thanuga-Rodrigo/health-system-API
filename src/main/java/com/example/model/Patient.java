/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author Laptop Outlet
 */
public class Patient extends Person {
    private String medicalHistory;
    private String currentStatus;
    
    public Patient() {
        // Default constructor
    }

    public Patient(String medicalHistory, String currentStatus, int id, String name, String contactInfo, String address) {
        super(id, name, contactInfo, address);
        this.medicalHistory = medicalHistory;
        this.currentStatus = currentStatus;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
    
}
