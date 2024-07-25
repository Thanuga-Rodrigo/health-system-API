/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.MedicalRecord;
import com.example.model.Patient;
import java.util.ArrayList;

/**
 *
 * @author Laptop Outlet
 */
public class MedicalRecordDAO {
    // Static list to store medical records
    private static ArrayList<MedicalRecord> medicalRecordList = new ArrayList<>();
    
    // Static initialization block to add sample data
    static {
        medicalRecordList.add(new MedicalRecord(1, 2, "Fever", "injection"));
        medicalRecordList.add(new MedicalRecord(2, 1, "cough", "tablets"));
        medicalRecordList.add(new MedicalRecord(3, 3, "Heart Attack","operation"));
    }
    //Retrieve the list of all medical records.
    public ArrayList<MedicalRecord> getMedicalRecordList() {
        return medicalRecordList;
    }
    // Add a new medical record to the system.
    public String addMedicalRecord(MedicalRecord medicalRecord) {
        int nextId;
        if(medicalRecordList.isEmpty()) {
            nextId = 1;
        } else {
            nextId = medicalRecordList.get(medicalRecordList.size() - 1).getMedicalRecordId() + 1; 
        }
        medicalRecord.setMedicalRecordId(nextId);
        medicalRecordList.add(medicalRecord);
        return "Medical Record " + nextId + " has been added to the system successfully";
    }
    // Update an existing medical record with new information.
    public String updateMedicalRecord(int userId, MedicalRecord updatedMedicalRecord){
        for(MedicalRecord medicalRecord : medicalRecordList){
            if(medicalRecord.getMedicalRecordId() == userId){
                medicalRecord.setPatientId(updatedMedicalRecord.getPatientId());
                medicalRecord.setDiagnoses(updatedMedicalRecord.getDiagnoses());
                medicalRecord.setTreatments(updatedMedicalRecord.getTreatments());
                return "Medical Record - " + userId + " details updated successfully!";
            }
        }
        return "MedicalRecord under ID - " + userId + " not found!";
    }
    //Delete a medical record from the system.
    public String deleteMedicalRecord(int userId){
        for (MedicalRecord medicalRecord : medicalRecordList){
            if(medicalRecord.getMedicalRecordId() == userId){
                medicalRecordList.remove(medicalRecord);
                return "Medical Record " + userId + " removed successfully from the system!";
            }
        }
        return "Medical Record under ID - " + userId + " not found!";
    }
    // Find a medical record by its ID and retrieve its details.
    public String getMedicalRecordById(int recordId) {
        for (MedicalRecord medicalRecord : medicalRecordList) {
            if (medicalRecord.getMedicalRecordId() == recordId) {
                Patient patient = null;
                // Retrieve patient information from PatientDAO
                ArrayList<Patient> patientList = new PatientDAO().getPatientList();
                // Find patient associated with the medical record
                for (Patient p : patientList) {
                    if (p.getId() == medicalRecord.getPatientId()) {
                        patient = p;
                        break;
                    }
                }

                // If patient found, return medical record details with patient information
                if (patient != null) {
                    return "Medical Record ID: " + medicalRecord.getMedicalRecordId() +
                            "\nPatient ID : " + medicalRecord.getPatientId() +
                            "\nDiagnoses : " + medicalRecord.getDiagnoses() +
                            "\nTreatments : " + medicalRecord.getTreatments() +
                            "\n\nPatient Name: " + patient.getName() +
                            "\nPatient Contact Info: " + patient.getContactInfo();
                } else {
                    // If patient not found, return medical record details without patient information
                    return "Medical Record ID: " + medicalRecord.getMedicalRecordId() +
                            "\nPatient ID : " + medicalRecord.getPatientId() +
                            "\nDiagnoses : " + medicalRecord.getDiagnoses() +
                            "\nTreatments : " + medicalRecord.getTreatments() +
                            "\nPatient details not found.";
                }
            }
        }
        // If medical record not found, return a message indicating        
        return "Medical Record with ID " + recordId + " not found.";
    }
}
