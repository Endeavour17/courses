package kg.megacom.courses.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courses_id")
    private Long id;
    private String name;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
