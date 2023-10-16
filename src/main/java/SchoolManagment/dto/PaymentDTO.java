package SchoolManagment.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentDTO {

    private String id;

    private BigDecimal amount;

    private StudentDTO student;

    private LocalDateTime create_at;

    private Timestamp update_at;

}
