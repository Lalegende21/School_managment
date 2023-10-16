package SchoolManagment.model;

import SchoolManagment.dto.LevelDTO;
import SchoolManagment.entity.Level;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LevelMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    //Methode pour convertir l' entite en DTO
    public LevelDTO mapLevelToDto(Level level) {
        return modelMapper.map(level, LevelDTO.class);
    }


    //Methode pour convertir le DTO en entite
    public Level mapDTOToLevel(LevelDTO levelDTO) {
        return modelMapper.map(levelDTO, Level.class);
    }
}
