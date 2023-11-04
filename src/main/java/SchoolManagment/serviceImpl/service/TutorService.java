package SchoolManagment.serviceImpl.service;


import SchoolManagment.entity.Tutor;

import java.util.List;

public interface TutorService {

    //Save tutor
    String saveTutor(Tutor tutor);

    //Read all tutors
    List<Tutor> getAllTutor();

    //Read tutor by id
    Tutor getTutor(String id);

    //Update tutor
    String updateTutor(String id, Tutor tutor);

    //Delete all tutors
    void deleteTutor();

    //Delete tutor by id
    void deleteTutorById(String id);

}
