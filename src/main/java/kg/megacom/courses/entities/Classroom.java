package kg.megacom.courses.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "classroom_id")
    private Long id;
    private String name;
}
