package SchoolManagment.controller;

import SchoolManagment.entity.Tutor;
import SchoolManagment.serviceImpl.TutorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "tutor")
public class TutorController {

    private final TutorServiceImpl tutorService;

    public TutorController(TutorServiceImpl tutorService) {
        this.tutorService = tutorService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody Tutor tutor) {
        this.tutorService.saveTutor(tutor);
        log.info("Tutor enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Tutor> getAllAdmin() {
        return this.tutorService.getAllTutor();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public Tutor getAdmin(@PathVariable String id) {
        return this.tutorService.getTutor(id);
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateTutor(@PathVariable String id, @RequestBody Tutor tutor) {
        this.tutorService.updateTutor(id, tutor);
        log.info("Mise a jour effectuee avec succes !");
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAllTutor() {
        this.tutorService.deleteTutor();
        log.info("Tous les tutor ont ete supprimes avec succes !");
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void deleteTutor(@PathVariable String id) {
        this.tutorService.deleteTutorByid(id);
        log.info("Tutor supprime avec succes !");
    }
}
