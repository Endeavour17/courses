package kg.megacom.courses.mappers;

import kg.megacom.courses.dto.CourseDto;
import kg.megacom.courses.dto.StudentDto;
import kg.megacom.courses.dto.TeacherDto;
import kg.megacom.courses.entities.Course;
import kg.megacom.courses.entities.Student;
import kg.megacom.courses.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClassMapper {

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    Course courseDtoToCourse(CourseDto courseDto);
    CourseDto courseToCourseDto(Course course);
    List<CourseDto> coursesToCourseDtos(List<Course> courses);

    Student studentDtoToStudent(StudentDto studentDto);
    StudentDto studentToStudentDto(Student student);
    List<StudentDto> studentsToStudentDtos(List<Student> students);

    Teacher teacherDtoToTeacher (TeacherDto teacherDto);
    TeacherDto teacherToTeacherDto(Teacher teacher);
    List<TeacherDto> teachersToTeacherDtos(List<Teacher> teachers);
}
