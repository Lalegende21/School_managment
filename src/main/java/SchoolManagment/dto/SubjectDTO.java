package SchoolManagment.dto;

import SchoolManagment.entity.Serie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SubjectDTO {

    private String id;

    private String name;

    private String coeff;

    private InstructorDTO instructor;

    private LevelDTO level;

    @JsonIgnore
    private List<Serie> series = new ArrayList<>();

//    private LocalDateTime create_at;
//
//    private Timestamp update_at;
}
