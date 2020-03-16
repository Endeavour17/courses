package kg.megacom.courses.aspects;

import kg.megacom.courses.dao.CourseDayRepo;
import kg.megacom.courses.dto.CourseDayDto;
import kg.megacom.courses.entities.CourseDay;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class ClassRoomAspect {

    @Autowired
    private CourseDayRepo courseDayRepo;

    @Before(value = "execution(* kg.megacom.courses.controllers.AdminController.*(..))")
    public void checkClassroomTime(CourseDayDto courseDayDto) {
        List<CourseDay> courseDays = courseDayRepo.findAll();

        courseDays.forEach(x-> {
            if (courseDayDto.getBeginTime().compareTo(x.getBeginTime()) >= 0 &&
                    courseDayDto.getBeginTime().compareTo(x.getEndTime()) <= 0 &&
                    courseDayDto.getDayId().equals(x.getDay().getId()) &&
            courseDayDto.getEndTime().compareTo(x.getBeginTime()) >= 0 &&
            courseDayDto.getEndTime().compareTo(x.getEndTime()) <= 0) {
                throw new RuntimeException("В указанное время в данной аудитории в этот день уже назначено другое занятие!");
            }
        });
    }
}
