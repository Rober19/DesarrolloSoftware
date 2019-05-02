/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Juan Manuel
 */
public class Persona implements Serializable{
    private int id;
    private String name;
    private String lastname;   
    private String email;
    private String programming_language;
    private ArrayList<String> hobbies;

    public Persona(int id, String name, String lastname, String email, String programming_language, ArrayList<String> hobbies) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.programming_language = programming_language;
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramming_language() {
        return programming_language;
    }

    public void setProgramming_language(String programming_language) {
        this.programming_language = programming_language;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }
    
    

}
