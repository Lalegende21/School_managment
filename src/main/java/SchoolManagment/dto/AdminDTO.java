package SchoolManagment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String image;

    @JsonIgnore
    private List<StudentDTO> students;

    @JsonIgnore
    private List<InstructorDTO> instructors;

//    private LocalDateTime create_at;
//
//    private Timestamp update_at;

}
