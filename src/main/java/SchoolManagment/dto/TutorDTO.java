package SchoolManagment.dto;

import SchoolManagment.enums.TutorType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class TutorDTO {

    private String id;

    private String fullName;

    private TutorType type;

    private String email;

    private String phoneNumber;

    @JsonIgnore
    private List<StudentDTO> students;

    @JsonIgnore
    private LocalDateTime create_at;

    @JsonIgnore
    private Timestamp update_at;
}
