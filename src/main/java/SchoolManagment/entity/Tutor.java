package SchoolManagment.entity;

import SchoolManagment.enums.TutorType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "fullName", nullable = false)
    @NotEmpty
    @Size(min = 3, max = 100, message = "fullName should have minimum 3 characters and maximum 100 characters")
    private String fullName;

    @Column(name = "type", nullable = false)
    private TutorType type;

    @Column(name = "email", nullable = false, unique = true)
    @NotEmpty
    @Size(min = 8, max = 100, message = "email should have have minimum 8 characters and maximum 100 characters")
    private String email;

    @Column(name = "phoneNumber", nullable = false, unique = true)
    @NotEmpty
    @Size(min = 9, max = 30, message = "phoneNumber should have have minimum 9 characters and maximum 30 characters")
    private String phoneNumber;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<Student> students;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp update_at;

}
