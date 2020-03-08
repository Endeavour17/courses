package kg.megacom.courses.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Long id;
    private String fio;
}
