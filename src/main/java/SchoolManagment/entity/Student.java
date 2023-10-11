package SchoolManagment.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "matricule", nullable = false, unique = true)
    private String matricule;

    @Column(name = "date_of_birth", nullable = false)
    private Date date_of_birth;

    @Column(name = "image", nullable = false, unique = true)
    private String image;

//    @ManyToOne
//    @JoinColumn(name = "admin_id")
//    private Admin admin;


//    @ManyToOne
//    @JoinColumn(name = "tutor_id")
//    private Tutor tutor;

//    @ManyToOne
//    @JoinColumn(name = "serie_id")
//    private Serie serie;


//      @ManyToOne
//    @JoinColumn(name = "paiement_id")
//    private Paiement paiement;


    @Column(name = "create_at", nullable = false)
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp update_at;

}
