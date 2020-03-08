package kg.megacom.courses.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CourseDto {
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private TeacherDto teacher;
}
