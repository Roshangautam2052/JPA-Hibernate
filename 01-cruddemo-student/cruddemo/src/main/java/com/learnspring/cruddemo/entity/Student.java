package com.learnspring.cruddemo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "student")
public class Student {
    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    // define constructors
    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;
    public Student(){

    }
    public Student(String first_name, String lastName, String email) {
        this.first_name = first_name;
        this.lastName = lastName;
        this.email = email;
    }

    // define getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    // define toString() method

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
