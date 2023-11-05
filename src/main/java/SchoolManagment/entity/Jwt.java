package SchoolManagment.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Jwt {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String value;
    private boolean desactiver;
    private boolean expired;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;
}
