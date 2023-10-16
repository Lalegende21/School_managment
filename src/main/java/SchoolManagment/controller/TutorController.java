package SchoolManagment.controller;

import SchoolManagment.dto.TutorDTO;
import SchoolManagment.entity.Tutor;
import SchoolManagment.model.TutorMapper;
import SchoolManagment.serviceImpl.TutorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "tutor")
public class TutorController {

    private final TutorServiceImpl tutorService;
    private final TutorMapper tutorMapper;

    public TutorController(TutorServiceImpl tutorService, TutorMapper tutorMapper) {

        this.tutorService = tutorService;
        this.tutorMapper = tutorMapper;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void Create(@RequestBody TutorDTO tutorDTO) {
        Tutor tutor = tutorMapper.mapDTOToTutor(tutorDTO);
        this.tutorService.saveTutor(tutor);
        log.info("Tutor enregistre avec succes !");
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<TutorDTO> getAllAdmin() {
        List<Tutor> tutors = this.tutorService.getAllTutor();
        return tutors.stream()
                .map(tutor -> tutorMapper.mapTutorToDto(tutor))
                .collect(Collectors.toList());
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}")
    public TutorDTO getAdmin(@PathVariable String id) {
        Tutor tutor = this.tutorService.getTutor(id);

        TutorDTO tutorDTO = tutorMapper.mapTutorToDto(tutor);

        return tutorDTO;
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void updateTutor(@PathVariable String id, @RequestBody TutorDTO tutorDTO) {
        Tutor tutor = tutorMapper.mapDTOToTutor(tutorDTO);
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
