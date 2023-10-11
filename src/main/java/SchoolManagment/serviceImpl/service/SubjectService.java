package SchoolManagment.serviceImpl.service;

import SchoolManagment.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {

    //Enregistrer un subject
    String saveSubject(Subject subject);

    //Afficher tous les subject
    List<Subject> getAllSubject();

    //Afficher un subject par son id
    Subject getSubject(String id);

    //MAJ des donnees d'un subject
    String updateSubject(String id, Subject subject);

    //Suppression de tous les subject
    void deleteSubject();

    //Suppression d'un subject par id
    void deleteSubjectByid(String id);
}
