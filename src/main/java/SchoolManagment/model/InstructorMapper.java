package SchoolManagment.model;

import SchoolManagment.dto.AdminDTO;
import SchoolManagment.dto.InstructorDTO;
import SchoolManagment.entity.Admin;
import SchoolManagment.entity.Instructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InstructorMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public InstructorDTO mapInstructorToDto(Instructor instructor) {
        return modelMapper.map(instructor, InstructorDTO.class);
    }


    //Methode pour convertir le DTO en entite
    public Instructor mapDTOToInstructor(InstructorDTO instructorDTO) {
        return modelMapper.map(instructorDTO, Instructor.class);
    }
}
