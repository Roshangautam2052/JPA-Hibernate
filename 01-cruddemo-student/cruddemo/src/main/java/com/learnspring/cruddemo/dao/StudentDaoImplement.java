package com.learnspring.cruddemo.dao;

import com.learnspring.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOimpl implements StudentDAO{
    // define field for entity mananger
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    


    @Override
    public void save(Student theStudent){

    }
}
