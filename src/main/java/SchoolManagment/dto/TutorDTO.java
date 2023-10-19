package SchoolManagment.dto;

import SchoolManagment.enums.TutorType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

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

//    private LocalDateTime create_at;
//
//    private Timestamp update_at;
}
