package SchoolManagment.controller;

import SchoolManagment.dto.SubjectDTO;
import SchoolManagment.entity.Subject;
import SchoolManagment.model.SubjectMapper;
import SchoolManagment.serviceImpl.SubjectServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "subject")
public class SubjectController {

    private final SubjectServiceImpl subjectService;
    private final SubjectMapper subjectMapper;



    //Method to save subject
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public String Create(@RequestBody SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.mapDTOToSubject(subjectDTO);
        this.subjectService.saveSubject(subject);
        return "Subject register successfully!";
    }



    //Method to read all subjects
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<SubjectDTO> getAllSubject() {
        List<Subject> subjects = this.subjectService.getAllSubject();
        return subjects.stream()
                .map(subject -> subjectMapper.mapSubjectToDto(subject))
                .collect(Collectors.toList());
    }



    //Method to read subject by id
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public SubjectDTO getAdmin(@PathVariable String id) {
        Subject subject = this.subjectService.getSubject(id);

        SubjectDTO subjectDTO = subjectMapper.mapSubjectToDto(subject);

        return subjectDTO;
    }



    //Method to update subject
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public String updateSubject(@PathVariable String id, @RequestBody SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.mapDTOToSubject(subjectDTO);
        this.subjectService.updateSubject(id, subject);
        return "Update complete successfully!";
    }


    //Method to delete all subjects
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping
    public String deleteAllSubject() {
        this.subjectService.deleteSubject();
        return "All subjects delete successfully!";
    }



    //Method to delete subject by id
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public String deleteSubject(@PathVariable String id) {
        this.subjectService.deleteSubjectById(id);
        return "Subject delete successfully!";
    }
}
