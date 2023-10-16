package SchoolManagment.dto;

import SchoolManagment.entity.Tutor;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TutorDTO {

    private String id;

    private String fullName;

    private String type;

    private String email;

    private String phoneNumber;

    private List<StudentDTO> students;

    private LocalDateTime create_at;

    private Timestamp update_at;
}
