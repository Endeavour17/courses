package kg.megacom.courses.controllers;

import kg.megacom.courses.dto.*;
import kg.megacom.courses.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("course/save")
    public ResponseEntity<?> saveCourse(@RequestBody CourseDto courseDto) {
        return ResponseEntity.ok(adminService.saveCourse(courseDto));
    }

    @GetMapping("course/all")
    public ResponseEntity<?> getCourses() {
        return ResponseEntity.ok(adminService.getCourses());
    }

    @GetMapping("courses/future")
    public ResponseEntity<?> getFutureCourses() {
        return ResponseEntity.ok(adminService.getFutureCourses());
    }

    @PostMapping("student/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(adminService.saveStudent(studentDto));
    }

    @PostMapping("student/register")
    public ResponseEntity<?> registerStudent(@RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(adminService.registerStudent(registerDto));
    }

    @PostMapping("classroom/save")
    public ResponseEntity<?> saveClassRoom(@RequestBody ClassroomDto classroomDto) {
        return ResponseEntity.ok(adminService.saveClassroom(classroomDto));
    }

    @GetMapping("classroom/all")
    public ResponseEntity<?> getClassRooms() {
        return ResponseEntity.ok(adminService.getDays());
    }

    @PostMapping("day/save")
    public ResponseEntity<?> saveDay(@RequestBody DayDto dayDto) {
        return ResponseEntity.ok(adminService.saveDay(dayDto));
    }

    @GetMapping("day/all")
    public ResponseEntity<?> getDays() {
        return ResponseEntity.ok(adminService.getDays());
    }

    @PostMapping("classroom/set/course")
    public ResponseEntity<?> setCourseClassroomAndDay(@RequestBody CourseDayDto courseDayDto) {
        return ResponseEntity.ok(adminService.setCourseClassroomAndDay(courseDayDto));
    }
}
