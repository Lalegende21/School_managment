package SchoolManagment.serviceImpl.service;

import SchoolManagment.entity.Instructor;

import java.util.List;

public interface InstructorService {

    //Save instructor
    String saveInstructor(Instructor instructor);

    //Read all instructors
    List<Instructor> getAllInstructor();

    //Read Instructor by id
    Instructor getInstructor(String id);

    //Update Instructor
    String updateInstructor(String id, Instructor instructor);

    //Delete all Instructors
    void deleteInstructor();

    //Delete Instructor by id
    void deleteInstructorById(String id);
}
