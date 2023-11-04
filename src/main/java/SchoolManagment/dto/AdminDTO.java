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
public class AdminDTO {

    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private String hash;

    private String phoneNumber;

    private ImageDTO image;

    @JsonIgnore
    private List<StudentDTO> students;

    @JsonIgnore
    private List<InstructorDTO> instructors;

    @JsonIgnore
    private LocalDateTime create_at;

    @JsonIgnore
    private Timestamp update_at;

}
