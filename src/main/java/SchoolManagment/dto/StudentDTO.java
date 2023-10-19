package SchoolManagment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class StudentDTO {

    private String id;

    private String firstname;

    private String lastname;

    private String matricule;

    private Date date_of_birth;

    private String image;

    private AdminDTO admin;

    private TutorDTO tutor;

    private SerieDTO serie;

    @JsonIgnore
    private List<PaymentDTO> payment;

//    private LocalDateTime create_at;
//
//    private Timestamp update_at;
}
