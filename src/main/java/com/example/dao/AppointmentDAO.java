/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.Patient;
import java.util.ArrayList;

/**
 *
 * @author Laptop Outlet
 */
public class AppointmentDAO {
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();
    
    
    static {
        // Initializing with some sample data
        appointmentList.add(new Appointment(1, 2, 1, "10/12/2023", "15.30", "2"));
        appointmentList.add(new Appointment(2, 3, 2, "04/05/2024", "20.30", "3"));
        appointmentList.add(new Appointment(3, 1, 3, "20/05/2024", "18.00", "1"));
    }
    
    //Retrieve the list of all appointments.

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }
    
    // Add a new appointment to the system.

    public String addAppointment(Appointment appointment) {
        int nextId;
        if(appointmentList.isEmpty()) {
            nextId = 1;
        } else {
            nextId = appointmentList.get(appointmentList.size() - 1).getAppointmentId() + 1; 
        }
        appointment.setAppointmentId(nextId);
        appointmentList.add(appointment);
        return "Appointment " + nextId + " has been added to the system successfully";
    }
    
    //Update an existing appointment with new information.
    
    public String updateAppointment(int userId, Appointment updatedAppointment){
        for(Appointment appointment : appointmentList){
            if(appointment.getAppointmentId() == userId){
                appointment.setDoctorId(updatedAppointment.getDoctorId());
                appointment.setPatientId(updatedAppointment.getPatientId());
                appointment.setDate(updatedAppointment.getDate());
                appointment.setTime(updatedAppointment.getTime());
                appointment.setParticipants(updatedAppointment.getParticipants());
                return "Appointment - " + userId + "details updated successfully!";
            }
        }
        return "Appointment under ID - " + userId + " not found!";
    }
     
    //Delete an appointment from the system using user given id
    
    public String deleteAppointment(int userId){
        for (Appointment appointment : appointmentList){
            if(appointment.getAppointmentId() == userId){
                appointmentList.remove(appointment);
                return "Appointment " + userId + " removed successfully from the system!";
            }
        }
        return "Appointment under ID - " + userId + " not found!";
    }
    
    // Retrieve the details of a specific appointment.
    public String getAppointmentDetails(int appointmentId) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentId() == appointmentId) {
                Patient patient = null;
                Doctor doctor = null;
                
                //// Retrieve patient and doctor information from respective DAOs
                ArrayList<Patient> patientList = new PatientDAO().getPatientList();
                ArrayList<Doctor> doctorList = new DoctorDAO().getDoctorList();

                // Find patient associated with the appointment

                for (Patient p : patientList) {
                    if (p.getId() == appointment.getPatientId()) {
                        patient = p;
                        break;
                    }
                }
                
                // Find doctor associated with the appointment

                for (Doctor d : doctorList) {
                    if (d.getId() == appointment.getDoctorId()) {
                        doctor = d;
                        break;
                    }
                }
                
                // If both patient and doctor found, return appointment details with their information

                if (patient != null && doctor != null) {
                    return "Appointment ID: " + appointment.getAppointmentId() +
                            "\nDate: " + appointment.getDate() +
                            "\nTime: " + appointment.getTime() +
                            "\nParticipants: " + appointment.getParticipants() +
                            "\n\nPatient ID: " + patient.getId()+
                            "\nPatient: " + patient.getName() +
                            "\nPatient Contact Info: " + patient.getContactInfo() +
                            "\n\nDoctor ID: " + doctor.getId() +
                            "\nDoctor Name: " + doctor.getName() +
                            "\nDoctor Contact Info: " + doctor.getContactInfo()+
                            "\nDoctor Specialization: " + doctor.getSpecialization();
                } else {
                    // If patient or doctor information not found, return appointment details without them
                    
                    
                    return "Appointment ID: " + appointment.getAppointmentId() +
                            "\nDate: " + appointment.getDate() +
                            "\nTime: " + appointment.getTime() +
                            "\nParticipants: " + appointment.getParticipants() +
                            "\nPatient ID: " + appointment.getPatientId() +
                            "\nDoctor ID: " + appointment.getDoctorId() +
                            "\nPatient or Doctor details not found.";
                }
            }
        }
        // If appointment not found, return a message indicating the same
        
        return "Appointment with ID " + appointmentId + " not found.";
    }

}
