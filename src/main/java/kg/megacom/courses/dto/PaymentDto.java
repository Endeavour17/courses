package kg.megacom.courses.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentDto {
    private Long id;
    private CourseDto course;
    private StudentDto student;
    private String description;
    private Date paymentDate;
    private boolean paymentStatus;
}
