package SchoolManagment.dto;

import SchoolManagment.entity.Level;
import SchoolManagment.enums.LevelType;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class LevelDTO {

    private String id;

    private String name;

    private LevelType type;            //Francophone ou anglophone

    private List<SubjectDTO> subjects;

    private LocalDateTime create_at;

    private Timestamp update_at;

}
