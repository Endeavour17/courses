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
    @Column(name = "lessons_per_week")
    private int lessonsPerWeek;
    @Column(name = "month_amount")
    private int monthAmount;
    @Column(name = "price_per_month")
    private double pricePerMonth;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
