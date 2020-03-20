package kg.megacom.courses.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Long id;
    @Column(name = "course_course_id")
    private Course course;
    @Column(name = "student_student_id")
    private Student student;
    private String description;
    @Column(name = "payment_date")
    private Date paymentDate;
    @Column(name = "payment_status")
    private boolean paymentStatus;
}
