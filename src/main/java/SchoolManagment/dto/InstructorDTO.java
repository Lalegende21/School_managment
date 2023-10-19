package SchoolManagment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String image;

    @JsonIgnore
    private AdminDTO admin;

    @JsonIgnore
    private List<SubjectDTO> subject;

//    private LocalDateTime create_at;
//
//    private Timestamp update_at;

}
