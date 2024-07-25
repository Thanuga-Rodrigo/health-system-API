/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author Laptop Outlet
 */
public class Doctor extends Person {
    private String specialization;
    private String contactDetails;
    
    public Doctor() {
        // Default constructor
    }

    public Doctor(String specialization, int id, String name, String contactInfo, String address) {
        super(id, name, contactInfo, address);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
