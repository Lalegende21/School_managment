package SchoolManagment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullName", nullable = false)
    @NotEmpty
    @Size(min = 3, max = 100, message = "fullName should have minimum 3 characters and maximum 100 characters")
    private String fullName;

    @Column(name = "type", nullable = false)
    @NotEmpty
    @Size(min = 5, max = 50, message = "type should have minimum 5 characters and have maximum 50 characters")
    private String type;

    @Column(name = "email", nullable = false, unique = true)
    @NotEmpty
    @Size(min = 8, max = 100, message = "email should have have minimum 8 characters and maximum 100 characters")
    private String email;

    @Column(name = "phoneNumber", nullable = false, unique = true)
    @NotEmpty
    @Size(min = 9, max = 30, message = "phoneNumber should have have minimum 9 characters and maximum 30 characters")
    private String phoneNumber;

    @Column(name = "create_at", nullable = false)
    @NotEmpty
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp update_at;

}
