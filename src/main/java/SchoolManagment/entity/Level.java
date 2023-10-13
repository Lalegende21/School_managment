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
@Table(name = "level")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false, unique = true)
    @NotEmpty
    @Size(min = 3, max = 100, message = "name should have minimum 3 characters and maximum 100 characters")
    private String name;

    @Column(name = "type", nullable = false)
    @NotEmpty
    @Size(min = 6, max = 20, message = "name should have minimum 6 characters and maximum 20 characters")
    private String type;            //Francophone ou anglophone

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    @NotEmpty
    private List<Subject> subjects;

    @Column(name = "create_at", nullable = false)
    @NotEmpty
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp update_at;

}
