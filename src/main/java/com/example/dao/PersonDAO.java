/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Person;
import java.util.ArrayList;

/**
 *
 * @author Laptop Outlet
 */
public class PersonDAO {
    // Static list to store person records
    private static ArrayList<Person> personList = new ArrayList<>();
    
    // Static initialization block to add sample data
    static {
        // Initializing with some sample data
        personList.add(new Person(1, "Thanuga", "0773015652", "Piliyandala"));
        personList.add(new Person(2, "Niketh", "0706015652", "Piliyandala"));
        personList.add(new Person(3, "Kavindu", "071165658", "Kesbewa"));
    }
    //Retrieve the list of all person records.
    public ArrayList<Person> getPersonList() {
        return personList;
    }
    //Add a new person record to the system.
    public String addPerson(Person person) {
        if (person == null) {
            return "Person object is null";
        }
        int nextId;
        if(personList.isEmpty()) {
            nextId = 1;
        } else {
            nextId = personList.get(personList.size() - 1).getId() + 1;
        }
        person.setId(nextId);
        personList.add(person);
        return "Person " + person.getName() + " has been added to the system successfully";
    }
    // Update an existing person record with new information.
    public String updatePerson(int userId, Person updatedPerson){
        for(Person person : personList){
            if(person.getId() == userId){
                person.setName(updatedPerson.getName());
                person.setAddress(updatedPerson.getAddress());
                person.setContactInfo(updatedPerson.getContactInfo());

                return "Person - " + userId + "details updated successfully!";
            }
        }
        return "Person under ID - " + userId + " not found!";
    }
    // Delete a person record from the system.
    public String deletePerson(int userId){
        for (Person person : personList){
            if(person.getId() == userId){
                personList.remove(person);
                return "Person " + person.getName() + " removed successfully from the system!";
            }
        }
        return "Person under ID - " + userId + " not found!";
    }
    //Find a person record by their ID and retrieve their details.
    public String findPersonById(int userId){
        for(Person person : personList){
            if(person.getId() == userId){
                return "Person ID - " + person.getId() +
                "\nPerson Name - " + person.getName() +
                "\nPerson contactInfo - " + person.getContactInfo() + 
                "\nPerson Address - " + person.getAddress();
            }
        }
        return "Person on ID - " + userId + " not found !";
    }
}
