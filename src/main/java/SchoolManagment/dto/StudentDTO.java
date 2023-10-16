package SchoolManagment.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
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

    private List<PaymentDTO> payment;

    private LocalDateTime create_at;

    private Timestamp update_at;
}
