package SchoolManagment.controller;

import SchoolManagment.dto.TutorDTO;
import SchoolManagment.entity.Tutor;
import SchoolManagment.model.TutorMapper;
import SchoolManagment.serviceImpl.TutorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "tutor")
public class TutorController {

    private final TutorServiceImpl tutorService;
    private final TutorMapper tutorMapper;



    //Method to save tutor
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public String Create(@RequestBody TutorDTO tutorDTO) {
        Tutor tutor = tutorMapper.mapDTOToTutor(tutorDTO);
        this.tutorService.saveTutor(tutor);
        return "Tutor register successfully!";
    }


    //Method to read all tutors
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<TutorDTO> getAllAdmin() {
        List<Tutor> tutors = this.tutorService.getAllTutor();
        return tutors.stream()
                .map(tutor -> tutorMapper.mapTutorToDto(tutor))
                .collect(Collectors.toList());
    }


    //Method to read tutor by id
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public TutorDTO getAdmin(@PathVariable String id) {
        Tutor tutor = this.tutorService.getTutor(id);

        TutorDTO tutorDTO = tutorMapper.mapTutorToDto(tutor);

        return tutorDTO;
    }



    //Method to update subject
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public String updateTutor(@PathVariable String id, @RequestBody TutorDTO tutorDTO) {
        Tutor tutor = tutorMapper.mapDTOToTutor(tutorDTO);
        this.tutorService.updateTutor(id, tutor);
        return "Update complete successfully!";
    }


    //Method to delete all tutors
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping
    public String deleteAllTutor() {
        this.tutorService.deleteTutor();
        return "All tutors delete successfully!";
    }


    //Method to delete tutor by id
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public String deleteTutor(@PathVariable String id) {
        this.tutorService.deleteTutorById(id);
        return "Tutor delete successfully!";
    }
}
