package SchoolManagment.controller;

import SchoolManagment.entity.Instructor;
import SchoolManagment.serviceImpl.InstructorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "instructor")
public class InstructorController {

    private InstructorServiceImpl instructorService;

    public InstructorController(InstructorServiceImpl instructorService) {
        this.instructorService = instructorService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody Instructor instructor) {
        this.instructorService.saveInstructor(instructor);
        log.info("instructeurr enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Instructor> getAllInstructor() {
        return this.instructorService.getAllInstructor();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public Instructor getInstructor(@PathVariable String id) {
        return this.instructorService.getInstructor(id);
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateAdmin(@PathVariable String id, @RequestBody Instructor instructor) {
        this.instructorService.updateInstructor(id, instructor);
        log.info("Mise a jour effectuee avec succes !");
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAllInstructor() {
        this.instructorService.getAllInstructor();
        log.info("Tous les instructeurs ont ete supprimes avec succes !");
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void deleteInstructor(@PathVariable String id) {
        this.instructorService.deleteInstructorByid(id);
        log.info("Instructeur supprime avec succes !");
    }
}
