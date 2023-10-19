//package SchoolManagment.model;
//
//import SchoolManagment.dto.Serie_SubjectDTO;
//import SchoolManagment.entity.Serie_Subject;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SerieSubjectMapper {
//
//    private final ModelMapper modelMapper = new ModelMapper();
//
//
//    public Serie_SubjectDTO mapSerieSubjectToDto(Serie_Subject serie_subject){
//        return modelMapper.map(serie_subject, Serie_SubjectDTO.class);
//    }
//
//
//    //Methode pour convertir le DTO en entite
//    public Serie_Subject mapDTOToSerieSubject(Serie_SubjectDTO serieSubjectDTO) {
//        return modelMapper.map(serieSubjectDTO, Serie_Subject.class);
//    }
//}
