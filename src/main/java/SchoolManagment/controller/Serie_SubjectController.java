package SchoolManagment.controller;

import SchoolManagment.dto.Serie_SubjectDTO;
import SchoolManagment.entity.Serie_Subject;
import SchoolManagment.model.SerieSubjectMapper;
import SchoolManagment.serviceImpl.Serie_SubjectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping(path = "serie_subject")
public class Serie_SubjectController {

    private final Serie_SubjectServiceImpl serie_subjectService;
    private final SerieSubjectMapper serieSubjectMapper;

    public Serie_SubjectController(Serie_SubjectServiceImpl serie_subjectService, SerieSubjectMapper serieSubjectMapper) {
        this.serie_subjectService = serie_subjectService;
        this.serieSubjectMapper = serieSubjectMapper;
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody Serie_SubjectDTO serie_subjectDTO) {
        Serie_Subject serieSubject = serieSubjectMapper.mapDTOToSerieSubject(serie_subjectDTO);
        this.serie_subjectService.saveSerie_Subject(serieSubject);
        log.info("serie_subject enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Serie_SubjectDTO> getAllAdmin() {
        List<Serie_Subject> serieSubjects = this.serie_subjectService.getAllSerie_Subject();
        return serieSubjects.stream()
                .map(serie_subject -> serieSubjectMapper.mapSerieSubjectToDto(serie_subject))
                .collect(Collectors.toList());
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public Serie_SubjectDTO getAdmin(@PathVariable String id) {
        Serie_Subject serieSubject = this.serie_subjectService.getSerie_Subject(id);

        Serie_SubjectDTO serieSubjectDTO = serieSubjectMapper.mapSerieSubjectToDto(serieSubject);

        return  serieSubjectDTO;
    }



    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateTutor(@PathVariable String id, @RequestBody Serie_SubjectDTO serie_subjectDTO) {
        Serie_Subject serieSubject = serieSubjectMapper.mapDTOToSerieSubject(serie_subjectDTO);
        this.serie_subjectService.updateSerie_Subject(id, serieSubject);
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
