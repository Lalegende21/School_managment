package SchoolManagment.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SubjectDTO {

    private String id;

    private String name;

    private String coeff;

    private InstructorDTO instructor;

    private LevelDTO level;

    private List<Serie_SubjectDTO> serie_subjects;

    private LocalDateTime create_at;

    private Timestamp update_at;
}
