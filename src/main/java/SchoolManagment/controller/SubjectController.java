package SchoolManagment.controller;

import SchoolManagment.dto.SubjectDTO;
import SchoolManagment.entity.Subject;
import SchoolManagment.model.SubjectMapper;
import SchoolManagment.serviceImpl.SubjectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "subject")
public class SubjectController {

    private final SubjectServiceImpl subjectService;
    private final SubjectMapper subjectMapper;

    public SubjectController(SubjectServiceImpl subjectService, SubjectMapper subjectMapper) {

        this.subjectService = subjectService;
        this.subjectMapper = subjectMapper;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.mapDTOToSubject(subjectDTO);
        this.subjectService.saveSubject(subject);
        log.info("Subject enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<SubjectDTO> getAllSubject() {
        List<Subject> subjects = this.subjectService.getAllSubject();
        return subjects.stream()
                .map(subject -> subjectMapper.mapSubjectToDto(subject))
                .collect(Collectors.toList());
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public SubjectDTO getAdmin(@PathVariable String id) {
        Subject subject = this.subjectService.getSubject(id);

        SubjectDTO subjectDTO = subjectMapper.mapSubjectToDto(subject);

        return subjectDTO;
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateSubject(@PathVariable String id, @RequestBody SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.mapDTOToSubject(subjectDTO);
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
