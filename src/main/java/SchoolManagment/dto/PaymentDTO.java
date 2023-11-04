package SchoolManagment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PaymentDTO {

    private String id;

    private BigDecimal amount;

    private StudentDTO student;

    @JsonIgnore
    private LocalDateTime create_at;

    @JsonIgnore
    private Timestamp update_at;

}
