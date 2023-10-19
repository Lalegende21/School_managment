package SchoolManagment.dto;

import SchoolManagment.entity.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SerieDTO {

    private String id;

    private String name;

    private BigDecimal amount;

    private BigDecimal firstinstallment;

    private BigDecimal secondinstallment;

    @JsonIgnore
    private List<StudentDTO> students;

    @JsonIgnore
    private List<Subject> subjects = new ArrayList<>();

//    private LocalDateTime create_at;
//
//    private Timestamp update_at;

}
