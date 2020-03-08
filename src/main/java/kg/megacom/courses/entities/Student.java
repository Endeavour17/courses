package kg.megacom.courses.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;
    private String fio;

    @ManyToMany
    @JoinTable(name = "courses_students",
            joinColumns = @JoinColumn(name = "course_course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_student_id"))
    private List<Course> courses;
}
