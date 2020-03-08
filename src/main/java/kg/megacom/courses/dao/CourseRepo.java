package kg.megacom.courses.dao;

import kg.megacom.courses.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    List<Course> findAllByBeginDateGreaterThan (Date date);
}
