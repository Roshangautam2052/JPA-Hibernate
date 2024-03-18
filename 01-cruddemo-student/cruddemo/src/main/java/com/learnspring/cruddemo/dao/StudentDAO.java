package com.learnspring.cruddemo.dao;

import com.learnspring.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

     void save(Student theStudent);

     Student findByID(Integer id);

     List<Student> findAll();

     List<Student> findByLastName(String LastName);

     void update(Student theStudent);

     void delete(Integer id);

     int  deleteAll();

}
