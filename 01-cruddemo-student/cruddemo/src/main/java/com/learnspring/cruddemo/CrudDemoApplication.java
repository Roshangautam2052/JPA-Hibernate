package com.learnspring.cruddemo;

import com.learnspring.cruddemo.dao.StudentDAO;
import com.learnspring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            createMultipleStudents(studentDAO);
        };
    }

    /***
     * This method creates multiple student objects with the given values and creates the database
     *  with corresponding fields in MySQL database
     *
     * @param studentDAO
     */
    private void createMultipleStudents(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating the student object");
        Student tempStudent = new Student("Roshan", "Gautam", "roshangautam045@gmail.com");
        Student tempStudent1 = new Student("Garima", "Gautam", "roshangautam09@gmail.com");
        Student tempStudent2 = new Student("Aakriti", "Gautam", "roshangautam04@gmail.com");
        Student tempStudent3 = new Student("Sarala", "Gautam", "roshangautam004@gmail.com");
        // After altering the autoincrement of id to start from value 3000;


        // save the student object
        System.out.println("Saving the Student");
        studentDAO.save(tempStudent);
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        // display id of the saved student
        System.out.println("Saved Student Generated id: " + tempStudent.getId());
        System.out.println("Saved Student Generated id: " + tempStudent1.getId());
        System.out.println("Saved Student Generated id: " + tempStudent2.getId());
        System.out.println("Saved Student Generated id: " + tempStudent3.getId());

    }

}
