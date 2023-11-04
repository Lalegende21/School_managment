package SchoolManagment.serviceImpl.service;

import SchoolManagment.entity.Subject;

import java.util.List;

public interface SubjectService {

    //Save subject
    String saveSubject(Subject subject);

    //Read all subjects
    List<Subject> getAllSubject();

    //Read subject by id
    Subject getSubject(String id);

    //Update subject
    String updateSubject(String id, Subject subject);

    //Delete all subjects
    void deleteSubject();

    //Delete subject by id
    void deleteSubjectById(String id);
}
