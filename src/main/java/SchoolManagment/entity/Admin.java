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
@Table(name = "admin")
public class Admin {

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

    @Column(name = "email", nullable = false, unique = true)
    @NotEmpty
    @Size(min = 8, max = 50, message = "lastname should have minimum 8 characters and maximum 50 characters")
    private String email;

    @Column(name = "hash", unique = false, nullable = false)
    @NotEmpty
    @Size(min = 8, max = 100, message = "hash should have minimum 8 characters and maximum 100 characters")
    private String hash;

    @Column(name = "phoneNumber", nullable = false)
    @NotEmpty
    @Size(min = 9, max = 15, message = "hash should have minimum 9 characters and maximum 15 characters")
    private String phoneNumber;

    @Column(name = "image", nullable = false, unique = true)
    @NotEmpty
    private String image;


    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Instructor> instructors;


    @Column(name = "create_at", nullable = false)
    @NotEmpty
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp update_at;

}
