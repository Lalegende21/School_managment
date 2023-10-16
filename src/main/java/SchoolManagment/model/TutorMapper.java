package SchoolManagment.model;

import SchoolManagment.dto.AdminDTO;
import SchoolManagment.dto.TutorDTO;
import SchoolManagment.entity.Admin;
import SchoolManagment.entity.Tutor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TutorMapper {

    private ModelMapper modelMapper = new ModelMapper();


    public TutorDTO mapTutorToDto(Tutor tutor){
        return modelMapper.map(tutor, TutorDTO.class);
    }


    //Methode pour convertir le DTO en entite
    public Tutor mapDTOToTutor(TutorDTO tutorDTO) {
        return modelMapper.map(tutorDTO, Tutor.class);
    }
}
