package SchoolManagment.model;

import SchoolManagment.dto.SerieDTO;
import SchoolManagment.entity.Serie;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SerieMapper {

    private final ModelMapper modelMapper = new ModelMapper();


    public SerieDTO mapSerieToDto(Serie serie){
        return modelMapper.map(serie, SerieDTO.class);
    }


    //Methode pour convertir le DTO en entite
    public Serie mapDTOToSerie(SerieDTO serieDTO) {
        return modelMapper.map(serieDTO, Serie.class);
    }
}
