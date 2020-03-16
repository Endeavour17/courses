package kg.megacom.courses.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class CourseDayDto {
    private Long id;
    private Long dayId;
    private Long courseId;
    private Long classroomId;
    private LocalTime beginTime;
    private LocalTime endTime;
}
