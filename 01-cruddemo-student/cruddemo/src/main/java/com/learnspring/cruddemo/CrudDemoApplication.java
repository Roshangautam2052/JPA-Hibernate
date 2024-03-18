package com.learnspring.cruddemo;

import com.learnspring.cruddemo.dao.StudentDAO;
import com.learnspring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            createMultipleStudents(studentDAO);

            //readStudent(studentDAO);

            //queryForStudents(studentDAO);

            //queryForStudentsByLastName(studentDAO);

            //updateStudent(studentDAO);
            
            //deleteStudent(studentDAO);

            //deleteAllStudents(studentDAO);
        };
    }

    /**
     * This method deletes the entire entry from the database table
     * @param studentDAO
     */
    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students ");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count= " + numRowsDeleted);
    }

    /**
     * This method deletes the Student entry with id =3
     * @param studentDAO
     */

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student id"+ studentId);
        studentDAO.delete(studentId);
    }

    /**
     * This method updates the column in the database based upon the id 
     * @param studentDAO
     */
    private void updateStudent(StudentDAO studentDAO) {

        //retrieve student based on id: primary key
        int studentId =1;
        System.out.println("Getting student with id:" + studentId);
        Student myStudent = studentDAO.findByID(studentId);

        // change the first name to "Scooby"
        System.out.println("Updating the Student");
        myStudent.setFirst_name("Scooby");

        // display the updated student
        System.out.println("Updated Student"+ myStudent);
        
    }


    /**
     * This method is used for getting all the entries in the database and printing them
     * @param studentDAO
     */
    private void queryForStudents(StudentDAO studentDAO) {
        //get a list of students
        List<Student> theStudents = studentDAO.findAll();


        // display the list of students
        for (Student x : theStudents) {
            System.out.println(theStudents);
        }
    }

    /**
     * This method find the name of student by lastName
     * @param studentDAO
     */
    private void queryForStudentsByLastName(StudentDAO studentDAO){
        List<Student> students = studentDAO.findByLastName("Duck");

        // display the list of students

        for(Student studentsByLastName: students){
            System.out.println(studentsByLastName);
        }

    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student
        System.out.println("Creating new student object....");
        Student tempStudent = new Student("Daffy", "Duck", "daffyduck@gmail.com");

        // save the student
        System.out.println("Saving the student....");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student" + theId);

        //retrieve student based on the id: primary key
        System.out.println("Retrieving student with id" + theId);
        Student myStudent = studentDAO.findByID(theId);

        // display student
        System.out.println("Found the student" + myStudent);
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

