/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Prescription;
import java.util.ArrayList;

/**
 *
 * @author Laptop Outlet
 */
public class PrescriptionDAO {
    // Static list to store prescription records
    private static ArrayList<Prescription> prescriptionList = new ArrayList<>();
    
    // Static initialization block to add sample data
    static {
        // Initializing with some sample data
        prescriptionList.add(new Prescription(1, "Thanuga","injection", "5", "after meals","5 days"));
        prescriptionList.add(new Prescription(2, "Niketh", "tablets", "2", "before meals", "10 days"));
        prescriptionList.add(new Prescription(3, "Kavindu", "operation", "10", "night", "3 days"));
    }
    //Retrieve the list of all prescription records.
    public ArrayList<Prescription> getPrescriptionList() {
        return prescriptionList;
    }
    //Add a new prescription record to the system.
    public String addPrescription(Prescription prescription) {
        int nextId;
        if(prescriptionList.isEmpty()) {
            nextId = 1;
        } else {
            nextId = prescriptionList.get(prescriptionList.size() - 1).getPrescriptionId() + 1;
        }
        prescription.setPrescriptionId(nextId);
        prescriptionList.add(prescription);
        return "Prescription of patient " + prescription.getPatientName() + " has been added to the system successfully";
    }
    //Update an existing prescription record with new information.
    public String updatePrescription(int userId, Prescription updatedPrescription){
        for(Prescription prescription : prescriptionList){
            if(prescription.getPrescriptionId() == userId){
                prescription.setPatientName(updatedPrescription.getPatientName());
                prescription.setMedications(updatedPrescription.getMedications());
                prescription.setDosage(updatedPrescription.getDosage());
                prescription.setInstructions(updatedPrescription.getInstructions());
                prescription.setDuration(updatedPrescription.getDuration());
                return "Prescription - " + userId + "details updated successfully!";
            }
        }
        return "Prescription under ID - " + userId + " not found!";
    }
    //Delete a prescription record from the system.
    public String deletePrescription(int userId){
        for (Prescription prescription : prescriptionList){
            if(prescription.getPrescriptionId() == userId){
                prescriptionList.remove(prescription);
                return "Prescription of patient " + prescription.getPatientName() + " removed successfully from the system!";
            }
        }
        return "Prescription under ID - " + userId + " not found!";
    }
    //Find a prescription record by its ID and retrieve its details.
    public String findPrescriptionById(int prescriptionId){
        for(Prescription prescription : prescriptionList){
            if(prescription.getPrescriptionId() == prescriptionId){
                return "Prescription ID - " + prescription.getPrescriptionId() +
                "\nPatient Name - " + prescription.getPatientName() +
                "\nMedications - " + prescription.getMedications()+ 
                "\nDosage - " + prescription.getDosage() + 
                "\nInstructions - " + prescription.getInstructions() + 
                "\nDuration - " + prescription.getDuration();
            }
        }
        return "Prescription on ID - " + prescriptionId + " not found !";
    }
}
