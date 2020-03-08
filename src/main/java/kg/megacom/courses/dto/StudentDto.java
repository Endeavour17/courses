package kg.megacom.courses.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private Long id;
    private String fio;
    private List<CourseDto> courses;
}
