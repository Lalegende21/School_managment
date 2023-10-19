package SchoolManagment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false, unique = true)
    @NotEmpty
    @Size(min = 3, max = 100, message = "name should have minimum 3 characters and maximum 100 characters")
    private String name;

    @Column(name = "coeff", nullable = false)
    @NotEmpty
    @Size(min = 1, max = 3, message = "coeff should have minimum 1 characters and maximum 3 characters")
    private String coeff;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private Level level;

//    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
//    private List<Serie_Subject> serieSubjects;


    @ManyToMany(mappedBy = "subjects")
    private List<Serie> series = new ArrayList<>();

    @Column(name = "create_at", nullable = false)
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp update_at;

}
