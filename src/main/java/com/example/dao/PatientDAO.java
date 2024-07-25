/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Patient;
import java.util.ArrayList;

/**
 *
 * @author Laptop Outlet
 */
public class PatientDAO {
        // Static list to store patient records
    private static ArrayList<Patient> patientList = new ArrayList<>();
    
    // Static initialization block to add sample data
    static {
        // Initializing with some sample data
        patientList.add(new Patient("New", "Fever", 1, "Thanuga", "0773015652", "Piliyandala"));
        patientList.add(new Patient("New", "Cough", 2, "Niketh", "0706015652", "Piliyandala"));
        patientList.add(new Patient("New", "Heart Attack", 3, "Kavindu", "071165658", "Kesbewa"));
    }
    //Retrieve the list of all patient records.
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }
    //Add a new patient record to the system.
    public String addPatient(Patient patient) {
        int nextId;
        if(patientList.isEmpty()) {
            nextId = 1;
        } else {
            nextId = patientList.get(patientList.size() - 1).getId() + 1;
        }
        patient.setId(nextId);
        patientList.add(patient);
        return "Patient " + patient.getName() + " has been added to the system successfully";
    }
    //Update an existing patient record with new information.
    public String updatePatient(int userId, Patient updatedPatient){
        for(Patient patient : patientList){
            if(patient.getId() == userId){
                patient.setName(updatedPatient.getName());
                patient.setAddress(updatedPatient.getAddress());
                patient.setContactInfo(updatedPatient.getContactInfo());
                patient.setCurrentStatus(updatedPatient.getCurrentStatus());
                patient.setMedicalHistory(updatedPatient.getMedicalHistory());
                return "Patient - " + userId + "details updated successfully!";
            }
        }
        return "Patient under ID - " + userId + " not found!";
    }
    // Delete a patient record from the system.
    public String deletePatient(int userId){
        for (Patient patient : patientList){
            if(patient.getId() == userId){
                patientList.remove(patient);
                return "Patient " + patient.getName() + " removed successfully from the system!";
            }
        }
        return "Patient under ID - " + userId + " not found!";
    }
    //Find a patient record by their ID and retrieve their details.
    public String findPatientById(int userId){
        for(Patient patient : patientList){
            if(patient.getId() == userId){
                return "Patient ID - " + patient.getId() +
                "\nPatient Name - " + patient.getName() +
                "\nPatient contactInfo - " + patient.getContactInfo() + 
                "\nPatient Address - " + patient.getAddress() + 
                "\nPatient Medical History - " + patient.getMedicalHistory() + 
                "\nPatient current health status - " + patient.getCurrentStatus();
            }
        }
        return "Patient on ID - " + userId + " not found !";
    }
}
