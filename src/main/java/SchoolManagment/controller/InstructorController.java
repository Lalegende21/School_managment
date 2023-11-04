package SchoolManagment.controller;

import SchoolManagment.dto.InstructorDTO;
import SchoolManagment.entity.Instructor;
import SchoolManagment.model.InstructorMapper;
import SchoolManagment.serviceImpl.InstructorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "instructor")
public class InstructorController {

    private InstructorServiceImpl instructorService;
    private final InstructorMapper instructorMapper;



    //Method to save instructor
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public String Create(@RequestBody InstructorDTO instructorDTO) {
        Instructor instructor = instructorMapper.mapDTOToInstructor(instructorDTO);
        this.instructorService.saveInstructor(instructor);
        return "Instructor register successfully!";
    }


    //Method to read all instructors
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<InstructorDTO> getAllInstructor() {
        List<Instructor> instructors = this.instructorService.getAllInstructor();
        return instructors.stream()
                .map(instructor -> instructorMapper.mapInstructorToDto(instructor))
                .collect(Collectors.toList());
//        return this.instructorService.getAllInstructor();
    }



    //Method to read instructor by id
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public InstructorDTO getInstructor(@PathVariable String id) {

        Instructor instructor = this.instructorService.getInstructor(id);

        InstructorDTO instructorDTO = instructorMapper.mapInstructorToDto(instructor);

        return instructorDTO;
    }



    //Method to update instructor
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public String updateAdmin(@PathVariable String id, @RequestBody InstructorDTO instructorDTO) {
        Instructor instructor = instructorMapper.mapDTOToInstructor(instructorDTO);
        this.instructorService.updateInstructor(id, instructor);
        return "Update complete successfully!";
    }


    //Method to delete all instructor
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping
    public String deleteAllInstructor() {
        this.instructorService.getAllInstructor();
        return "All instructor delete successfully!";
    }



    //Method to delete instructor by id
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public String deleteInstructor(@PathVariable String id) {
        this.instructorService.deleteInstructorById(id);
        return "Instructor delete successfully!";
    }
}
