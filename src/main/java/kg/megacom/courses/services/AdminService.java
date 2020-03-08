package kg.megacom.courses.services;

import kg.megacom.courses.dto.CourseDto;
import kg.megacom.courses.dto.RegisterDto;
import kg.megacom.courses.dto.StudentDto;
import kg.megacom.courses.dto.TeacherDto;

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
}
