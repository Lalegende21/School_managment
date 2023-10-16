package SchoolManagment.controller;

import SchoolManagment.dto.InstructorDTO;
import SchoolManagment.entity.Instructor;
import SchoolManagment.model.InstructorMapper;
import SchoolManagment.serviceImpl.InstructorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "instructor")
public class InstructorController {

    private InstructorServiceImpl instructorService;
    private final InstructorMapper instructorMapper;

    public InstructorController(InstructorServiceImpl instructorService, InstructorMapper instructorMapper) {
        this.instructorService = instructorService;
        this.instructorMapper = instructorMapper;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody InstructorDTO instructorDTO) {
        Instructor instructor = instructorMapper.mapDTOToInstructor(instructorDTO);
        this.instructorService.saveInstructor(instructor);
        log.info("instructeurr enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<InstructorDTO> getAllInstructor() {
        List<Instructor> instructors = this.instructorService.getAllInstructor();
        return instructors.stream()
                .map(instructor -> instructorMapper.mapInstructorToDto(instructor))
                .collect(Collectors.toList());
//        return this.instructorService.getAllInstructor();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public InstructorDTO getInstructor(@PathVariable String id) {

        Instructor instructor = this.instructorService.getInstructor(id);

        InstructorDTO instructorDTO = instructorMapper.mapInstructorToDto(instructor);

        return instructorDTO;
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateAdmin(@PathVariable String id, @RequestBody InstructorDTO instructorDTO) {
        Instructor instructor = instructorMapper.mapDTOToInstructor(instructorDTO);
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
