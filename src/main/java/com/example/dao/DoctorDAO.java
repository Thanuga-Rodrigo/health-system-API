/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Doctor;
import java.util.ArrayList;

/**
 *
 * @author Laptop Outlet
 */
public class DoctorDAO {
    // Static list to store doctor records
    private static ArrayList<Doctor> doctorList = new ArrayList<>();
    
    
    static {
        doctorList.add(new Doctor("body", 1, "John", "0773015652", "London"));
        doctorList.add(new Doctor("cardiologist", 2, "Franklin", "0706015652", "Los Santos"));
        doctorList.add(new Doctor("heart", 3, "Trevor", "071165658", "Paleto Bay"));
    }
    //Retrieve the list of all doctor records.
    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }
    //Add a new doctor record to the system.
    public String addDoctor(Doctor doctor) {
        int nextId;
        if(doctorList.isEmpty()) {
            nextId = 1; 
        } else {
            nextId = doctorList.get(doctorList.size() - 1).getId() + 1; 
        }
        doctor.setId(nextId);
        doctorList.add(doctor);
        return "Doctor " + doctor.getName() + " has been added to the system successfully";
    }
    //Update an existing doctor record with new information.
    public String updateDoctor(int userId, Doctor updatedDoctor){
        for(Doctor doctor : doctorList){
            if(doctor.getId() == userId){
                doctor.setName(updatedDoctor.getName());
                doctor.setAddress(updatedDoctor.getAddress());
                doctor.setContactInfo(updatedDoctor.getContactInfo());
                doctor.setSpecialization(updatedDoctor.getSpecialization());
                return "Doctor - " + userId + "details updated successfully!";
            }
        }
        return "Doctor under ID - " + userId + " not found!";
    }
    // Delete a doctor record from the system.
    public String deleteDoctor(int userId){
        for (Doctor doctor : doctorList){
            if(doctor.getId() == userId){
                doctorList.remove(doctor);
                return "Doctor " + doctor.getName() + " removed successfully from the system!";
            }
        }
        return "Doctor under ID - " + userId + " not found!";
    }
    //Find a doctor record by their ID and retrieve their details.
    public String findDoctorById(int userId){
        for(Doctor doctor : doctorList){
            if(doctor.getId() == userId){
                return "Doctor ID - " + doctor.getId() +
                "\nDoctor Name - " + doctor.getName() +
                "\nDoctor contactInfo - " + doctor.getContactInfo() + 
                "\nDoctor Address - " + doctor.getAddress() + 
                "\nDoctor specializatiom - " + doctor.getSpecialization();
            }
        }
        return "Doctor on ID - " + userId + " not found !";
    }
}