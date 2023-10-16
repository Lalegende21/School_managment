package SchoolManagment.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
public class Serie_SubjectDTO {

    private String id;

    private SubjectDTO subjectDTO;

    private SerieDTO serieDTO;

    private LocalDateTime create_at;

    private Timestamp update_at;

}
