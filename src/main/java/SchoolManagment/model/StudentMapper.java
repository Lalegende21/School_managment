package SchoolManagment.model;

import SchoolManagment.dto.StudentDTO;
import SchoolManagment.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private final ModelMapper modelMapper = new ModelMapper();


    public StudentDTO mapStudentToDto(Student student){
        return modelMapper.map(student, StudentDTO.class);
    }



    //Methode pour convertir le DTO en entite
    public Student mapDTOToStudent(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }
}
