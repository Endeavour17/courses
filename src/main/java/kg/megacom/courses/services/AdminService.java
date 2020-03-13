package kg.megacom.courses.services;

import kg.megacom.courses.dto.*;

import java.util.List;

public interface AdminService {

    CourseDto saveCourse(CourseDto courseDto);
    List<CourseDto> getCourses();
    List<CourseDto> getFutureCourses();

    StudentDto saveStudent(StudentDto studentDto);
    List<StudentDto> getStudents();
    StudentDto registerStudent(RegisterDto registerDto);

    TeacherDto saveTeacher(TeacherDto teacherDto);
    List<TeacherDto> getTeachers();

    ClassroomDto saveClassroom(ClassroomDto classroomDto);
    List<ClassroomDto> getClassrooms();

    DayDto saveDay(DayDto dayDto);
    List<DayDto> getDays();

    CourseDayDto setCourseClassroomAndDay(CourseDayDto courseDayDto);
}
