/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

/**
 *
 * @author Korisnik
 */
public class Journalists {
    private int id;
    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private String picturePath;

    public Journalists() {
    }

    public Journalists(String firstName, String lastName, String age, String email, String picturePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.picturePath = picturePath;
    }

    public Journalists(int id, String firstName, String lastName, String age, String email, String picturePath) {
        this(firstName, lastName, age,email,picturePath);
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

     @Override
    public String toString() {
        String fullname = firstName +" "+ lastName;
        return id + " - " + fullname ;
    }
    
}
