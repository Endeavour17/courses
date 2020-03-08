package kg.megacom.courses.services.impl;

import kg.megacom.courses.dao.CourseRepo;
import kg.megacom.courses.dao.StudentRepo;
import kg.megacom.courses.dao.TeacherRepo;
import kg.megacom.courses.dto.CourseDto;
import kg.megacom.courses.dto.RegisterDto;
import kg.megacom.courses.dto.StudentDto;
import kg.megacom.courses.dto.TeacherDto;
import kg.megacom.courses.entities.Course;
import kg.megacom.courses.entities.Student;
import kg.megacom.courses.entities.Teacher;
import kg.megacom.courses.mappers.ClassMapper;
import kg.megacom.courses.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        Teacher teacher = ClassMapper.INSTANCE.teacherDtoToTeacher(courseDto.getTeacher());
        Course course = ClassMapper.INSTANCE.courseDtoToCourse(courseDto);
        course.setTeacher(teacher);
        course = courseRepo.save(course);
        return ClassMapper.INSTANCE.courseToCourseDto(course);
    }

    @Override
    public List<CourseDto> getCourses() {
        List<Course> courses = courseRepo.findAll();
        return ClassMapper.INSTANCE.coursesToCourseDtos(courses);
    }

    @Override
    public List<CourseDto> getFutureCourses() {
        List<Course> courses = courseRepo.findAllByBeginDateGreaterThan(new Date());
        return ClassMapper.INSTANCE.coursesToCourseDtos(courses);
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = ClassMapper.INSTANCE.studentDtoToStudent(studentDto);
        student = studentRepo.save(student);
        return ClassMapper.INSTANCE.studentToStudentDto(student);
    }

    @Override
    public List<StudentDto> getStudents() {
        List<Student> students = studentRepo.findAll();
        return ClassMapper.INSTANCE.studentsToStudentDtos(students);
    }

    @Override
    public StudentDto registerStudent(RegisterDto registerDto) {
        Student student = studentRepo.findById(registerDto.getStudentId()).orElse(null);

        if (student == null) {
            throw new RuntimeException("Студент с таким id не существует!");
        }

        Course course = courseRepo.findById(registerDto.getCourseId()).orElse(null);

        if (course == null) {
            throw new RuntimeException("Курс с таким id не существует");
        }

        List<Course> studentCourses = student.getCourses();

        studentCourses.add(course);

        student.setCourses(studentCourses);

        student = studentRepo.save(student);

        return ClassMapper.INSTANCE.studentToStudentDto(student);
    }

    @Override
    public TeacherDto saveTeacher(TeacherDto teacherDto) {
        Teacher teacher = ClassMapper.INSTANCE.teacherDtoToTeacher(teacherDto);
        teacher = teacherRepo.save(teacher);
        return ClassMapper.INSTANCE.teacherToTeacherDto(teacher);
    }

    @Override
    public List<TeacherDto> getTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();
        return ClassMapper.INSTANCE.teachersToTeacherDtos(teachers);
    }
}