package kg.megacom.courses.mappers;

import kg.megacom.courses.dto.*;
import kg.megacom.courses.entities.*;
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

    Classroom classroomDtoToClassroom(ClassroomDto classroomDto);
    ClassroomDto classroomToClassroomDto(Classroom classroom);
    List<ClassroomDto> classroomsToClassroomDtos(List<Classroom> classrooms);

    Day dayDtoToDay(DayDto dayDto);
    DayDto dayToDayDto(Day day);
    List<DayDto> daysToDayDtos(List<Day> days);


    CourseDayDto courseDayToCourseDayDto(CourseDay courseDay);

}
