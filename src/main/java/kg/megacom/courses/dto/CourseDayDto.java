package kg.megacom.courses.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CourseDayDto {
    private Long id;
    private Long dayId;
    private Long courseId;
    private Long classroomId;
    private Date beginTime;
    private Date endTime;
}
