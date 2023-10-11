package SchoolManagment.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "instructor")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "registration_fee", nullable = false)
    private BigDecimal amount;

    @Column(name = "first-installment", nullable = false)
    private BigDecimal firstinstallment;

    @Column(name = "second-installment", nullable = false)
    private BigDecimal secondinstallment;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp update_at;

}
