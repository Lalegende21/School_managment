package SchoolManagment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Instant creation;
    private Instant expiration;
    private Instant activation;
    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
