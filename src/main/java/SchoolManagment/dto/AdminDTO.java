package SchoolManagment.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class AdminDTO {

    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private String hash;

    private String phoneNumber;

    private String image;

    private List<StudentDTO> students;

    private List<InstructorDTO> instructors;

    private LocalDateTime create_at;

    private Timestamp update_at;

}
