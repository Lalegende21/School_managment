package SchoolManagment.entity;

import SchoolManagment.enums.TypeRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private TypeRole libelle;
}
