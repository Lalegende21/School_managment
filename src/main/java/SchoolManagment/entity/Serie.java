package SchoolManagment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false, unique = true)
    @NotEmpty
    @Size(min = 3, max = 100, message = "name should have minimum 3 characters and maximum 100 characters")
    private String name;

    @Column(name = "registration_fee", nullable = false)
    @NotNull
    private BigDecimal amount;

    @Column(name = "first-installment", nullable = false)
    @NotNull
    private BigDecimal firstinstallment;

    @Column(name = "second-installment", nullable = false)
    @NotNull
    private BigDecimal secondinstallment;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<Student> students;


    @ManyToMany
    @JoinTable(
            name = "series_subject",
            joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects = new ArrayList<>();

    @Column(name = "create_at", nullable = false)
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp update_at;

}
