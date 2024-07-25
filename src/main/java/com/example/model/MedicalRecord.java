/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author Laptop Outlet
 */
public class MedicalRecord {
    private int medicalRecordId;
    private int patientId;
    private String diagnoses;
    private String treatments;
    
    public MedicalRecord() {
        // Default constructor
    }

    public MedicalRecord(int medicalRecordId, int patientId, String diagnoses, String treatments) {
        this.medicalRecordId = medicalRecordId;
        this.patientId = patientId;
        this.diagnoses = diagnoses;
        this.treatments = treatments;
    }

    public int getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(int medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }
    
    
}
