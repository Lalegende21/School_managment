package SchoolManagment.dto;

import SchoolManagment.entity.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class InstructorDTO {

    private String id;

    private String firstname;

    private String lastname;

    private String CNI;

    private String email;

    private String phoneNumber;

    private ImageDTO image;

    private AdminDTO admin;

    @JsonIgnore
    private List<SubjectDTO> subject;

    @JsonIgnore
    private LocalDateTime create_at;

    @JsonIgnore
    private Timestamp update_at;

}
