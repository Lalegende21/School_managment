package SchoolManagment.dto;

import SchoolManagment.entity.Admin;
import SchoolManagment.entity.Instructor;
import SchoolManagment.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ImageDTO {

    private String id;

    private String imageUrl;

    private String imageId;

    private Admin admin;

    private Student student;

    private Instructor instructor;

    @JsonIgnore
    private LocalDateTime create_at;

    @JsonIgnore
    private Timestamp update_at;
}
