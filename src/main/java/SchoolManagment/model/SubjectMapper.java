package SchoolManagment.model;

import SchoolManagment.dto.SubjectDTO;
import SchoolManagment.entity.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {

    private ModelMapper modelMapper = new ModelMapper();


    public SubjectDTO mapSubjectToDto(Subject subject){
        return modelMapper.map(subject, SubjectDTO.class);
    }


    //Methode pour convertir le DTO en entite
    public Subject mapDTOToSubject(SubjectDTO subjectDTO) {
        return modelMapper.map(subjectDTO, Subject.class);
    }
}
