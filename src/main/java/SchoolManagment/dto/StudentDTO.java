package SchoolManagment.dto;

import SchoolManagment.entity.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentDTO {

    private String id;

    private String firstname;

    private String lastname;

    private String matricule;

    private Date date_of_birth;

    private ImageDTO image;

    private AdminDTO admin;

    private TutorDTO tutor;

    private SerieDTO serie;

    @JsonIgnore
    private List<PaymentDTO> payment;

    @JsonIgnore
    private LocalDateTime create_at;

    @JsonIgnore
    private Timestamp update_at;
}
