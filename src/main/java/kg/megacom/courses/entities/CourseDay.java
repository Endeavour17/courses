package kg.megacom.courses.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "course_days")
public class CourseDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_days_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "day_day_id")
    private Day day;
    @ManyToOne
    @JoinColumn(name = "course_course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "classroom_classroom_id")
    private Classroom classroom;
    private Date beginTime;
    private Date endTime;
}
