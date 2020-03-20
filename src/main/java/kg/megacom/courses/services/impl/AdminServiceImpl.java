package kg.megacom.courses.services.impl;

import kg.megacom.courses.dao.*;
import kg.megacom.courses.dto.*;
import kg.megacom.courses.entities.*;
import kg.megacom.courses.mappers.ClassMapper;
import kg.megacom.courses.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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

    @Autowired
    private ClassroomRepo classroomRepo;

    @Autowired
    private DayRepo dayRepo;

    @Autowired
    private CourseDayRepo courseDayRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        Teacher teacher = ClassMapper.INSTANCE.teacherDtoToTeacher(courseDto.getTeacherDto());
        Course course = ClassMapper.INSTANCE.courseDtoToCourse(courseDto);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(course.getStartDate());
        calendar.add(Calendar.MONTH, course.getMonthAmount());
        course.setEndDate(calendar.getTime());

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

    @Override
    public ClassroomDto saveClassroom(ClassroomDto classroomDto) {
        Classroom classroom = ClassMapper.INSTANCE.classroomDtoToClassroom(classroomDto);
        classroom = classroomRepo.save(classroom);
        return ClassMapper.INSTANCE.classroomToClassroomDto(classroom);
    }

    @Override
    public List<ClassroomDto> getClassrooms() {
        List<Classroom> classrooms = classroomRepo.findAll();
        return ClassMapper.INSTANCE.classroomsToClassroomDtos(classrooms);
    }

    @Override
    public DayDto saveDay(DayDto dayDto) {
        Day day = ClassMapper.INSTANCE.dayDtoToDay(dayDto);
        day = dayRepo.save(day);
        return ClassMapper.INSTANCE.dayToDayDto(day);
    }

    @Override
    public List<DayDto> getDays() {
        List<Day> days = dayRepo.findAllByActiveTrue();
        return ClassMapper.INSTANCE.daysToDayDtos(days);
    }

    @Override
    public CourseDayDto setCourseClassroomAndDay(CourseDayDto courseDayDto) {
        Course course = courseRepo.findById(courseDayDto.getCourseId()).orElse(null);
        if (course == null) {
            throw new RuntimeException("Курса с таким id не существует!");
        }

        Classroom classroom = classroomRepo.findById(courseDayDto.getClassroomId()).orElse(null);
        if (classroom == null) {
            throw new RuntimeException("Аудитории с таким id не существует!");
        }

        Day day = dayRepo.findById(courseDayDto.getDayId()).orElse(null);
        if (day == null) {
            throw new RuntimeException("Дня недели с таким id не существует!");
        }

        CourseDay courseDay = new CourseDay();
        courseDay.setCourse(course);
        courseDay.setClassroom(classroom);
        courseDay.setDay(day);
        courseDay.setBeginTime(courseDayDto.getBeginTime());
        courseDay.setEndTime(courseDayDto.getEndTime());

        courseDay = courseDayRepo.save(courseDay);

        return ClassMapper.INSTANCE.courseDayToCourseDayDto(courseDay);
    }

    @Override
    public PaymentDto addPayment(PaymentDto paymentDto) {
        Payment payment = ClassMapper.INSTANCE.paymentDtoToPayment(paymentDto);
        Student student = ClassMapper.INSTANCE.studentDtoToStudent(paymentDto.getStudent());
        Course course = ClassMapper.INSTANCE.courseDtoToCourse(paymentDto.getCourse());
        payment.setStudent(student);
        payment.setCourse(course);
        payment = paymentRepo.save(payment);
        return ClassMapper.INSTANCE.paymentToPaymentDto(payment);
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        List<Payment> payments = paymentRepo.findAll();
        return ClassMapper.INSTANCE.paymentsToPaymentDtos(payments);
    }

    @Override
    public List<PaymentDto> getAllPaymentsByStudent(StudentDto studentDto) {
        Student student = ClassMapper.INSTANCE.studentDtoToStudent(studentDto);
        List<Payment> payments = paymentRepo.findAllPaymentByStudent(student);
        return ClassMapper.INSTANCE.paymentsToPaymentDtos(payments);
    }

    @Override
    public List<PaymentDto> getAllPaymentsByCourse(CourseDto courseDto) {
        Course course = ClassMapper.INSTANCE.courseDtoToCourse(courseDto);
        List<Payment> payments = paymentRepo.findAllPaymentByCourse(course);
        return ClassMapper.INSTANCE.paymentsToPaymentDtos(payments);
    }
}