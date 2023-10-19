package SchoolManagment.dto;

import SchoolManagment.enums.LevelType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LevelDTO {

    private String id;

    private String name;

    private LevelType type;            //Francophone ou anglophone

    @JsonIgnore
    private List<SubjectDTO> subjects;

//    private LocalDateTime create_at;
//
//    private Timestamp update_at;

}
