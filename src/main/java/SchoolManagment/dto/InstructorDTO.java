package SchoolManagment.dto;

import SchoolManagment.entity.Admin;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class InstructorDTO {

    private String id;

    private String firstname;

    private String lastname;

    private String CNI;

    private String email;

    private String phoneNumber;

    private String image;

    private Admin admin;

    private List<SubjectDTO> subject;

    private LocalDateTime create_at;

    private Timestamp update_at;

}
