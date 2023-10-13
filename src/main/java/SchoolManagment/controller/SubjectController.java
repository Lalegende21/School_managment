package SchoolManagment.controller;

import SchoolManagment.entity.Subject;
import SchoolManagment.serviceImpl.SubjectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "subject")
public class SubjectController {

    private final SubjectServiceImpl subjectService;

    public SubjectController(SubjectServiceImpl subjectService) {
        this.subjectService = subjectService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody Subject subject) {
        this.subjectService.saveSubject(subject);
        log.info("Subject enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Subject> getAllSubject() {
        return this.subjectService.getAllSubject();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public Subject getAdmin(@PathVariable String id) {
        return this.subjectService.getSubject(id);
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateSubject(@PathVariable String id, @RequestBody Subject subject) {
        this.subjectService.updateSubject(id, subject);
        log.info("Mise a jour effectuee avec succes !");
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAllSubject() {
        this.subjectService.deleteSubject();
        log.info("Tous les subject ont ete supprimes avec succes !");
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void deleteSubject(@PathVariable String id) {
        this.subjectService.deleteSubjectByid(id);
        log.info("Subject supprime avec succes !");
    }
}
