package com.learnspring.cruddemo.dao;

import com.learnspring.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImplement implements StudentDAO{
    // define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDaoImplement(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implement the save method
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }
}
