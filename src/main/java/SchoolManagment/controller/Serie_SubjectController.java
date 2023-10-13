package SchoolManagment.controller;

import SchoolManagment.entity.Serie_Subject;
import SchoolManagment.serviceImpl.Serie_SubjectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(path = "serie_subject")
public class Serie_SubjectController {

    private final Serie_SubjectServiceImpl serie_subjectService;

    public Serie_SubjectController(Serie_SubjectServiceImpl serie_subjectService) {
        this.serie_subjectService = serie_subjectService;
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody Serie_Subject serie_subject) {
        this.serie_subjectService.saveSerie_Subject(serie_subject);
        log.info("serie_subject enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Serie_Subject> getAllAdmin() {
        return this.serie_subjectService.getAllSerie_Subject();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public Serie_Subject getAdmin(@PathVariable String id) {
        return this.serie_subjectService.getSerie_Subject(id);
    }



    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateTutor(@PathVariable String id, @RequestBody Serie_Subject serie_subject) {
        this.serie_subjectService.updateSerie_Subject(id, serie_subject);
        log.info("Mise a jour effectuee avec succes !");
    }



    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAllTutor() {
        this.serie_subjectService.deleteSerie_Subject();
        log.info("Tous les serie_subject ont ete supprimes avec succes !");
    }



    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void deleteTutor(@PathVariable String id) {
        this.serie_subjectService.deleteSerie_SubjectByid(id);
        log.info("serie_subject supprime avec succes !");
    }
}
