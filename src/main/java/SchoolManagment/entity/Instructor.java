package SchoolManagment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "firstname", nullable = false)
    @NotEmpty
    @Size(min = 3, max = 100, message = "firstname should have minimum 3 characters and maximum 100 characters")
    private String firstname;

    @Column(name = "lastname", nullable = false)
    @NotEmpty
    @Size(min = 3, max = 100, message = "lastname should have minimum 3 characters and maximum 100 characters")
    private String lastname;

    @Column(name = "cni", nullable = false)
    @NotEmpty
    @Size(min = 17, max = 100, message = "CNI should have minimum 17 characters and maximum 100 characters")
    private String CNI;

    @Column(name = "email", nullable = false, unique = true)
    @NotEmpty
    @Size(min = 8, max = 100, message = "email should have minimum 8 characters and maximum 100 characters")
    private String email;

    @Column(name = "phoneNumber", nullable = false, unique = true)
    @NotEmpty
    @Size(min = 9, max = 30, message = "firstname should have minimum 9 characters and maximum 30 characters")
    private String phoneNumber;

    @OneToOne(mappedBy = "instructor", cascade = CascadeType.ALL)
    private Image image;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Subject> subject;


    @Column(name = "create_at", nullable = false)
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp update_at;

}
