/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author Laptop Outlet
 */
public class Prescription {
    private int prescriptionId;
    private String patientName;
    private String medications;
    private String dosage;
    private String instructions;
    private String duration;
    
    public Prescription() {
        // Default constructor
    }
    public Prescription(int prescriptionId, String patientName, String medications, String dosage, String instructions, String duration) {
        this.prescriptionId = prescriptionId;
        this.patientName = patientName;
        this.medications = medications;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
}
