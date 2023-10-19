package SchoolManagment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "student")
public class Student {

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

    @Column(name = "matricule", nullable = false, unique = true)
    @NotEmpty
    @Size(min = 3, max = 100, message = "matricule should have minimum 3 characters and maximum 100 characters")
    private String matricule;

    @Column(name = "date_of_birth", nullable = false)
    @NotNull
    private Date date_of_birth;

    @Column(name = "image", nullable = false, unique = true)
    @NotEmpty
    private String image;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;


    @ManyToOne
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    private Serie serie;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Payment> payment;


    @Column(name = "create_at", nullable = false)
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp update_at;
}
