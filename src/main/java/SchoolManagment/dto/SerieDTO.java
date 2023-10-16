package SchoolManagment.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SerieDTO {

    private String id;

    private String name;

    private BigDecimal amount;

    private BigDecimal firstinstallment;

    private BigDecimal secondinstallment;

    private List<StudentDTO> students;

    private List<Serie_SubjectDTO> serie_subjects;

    private LocalDateTime create_at;

    private Timestamp update_at;

}
