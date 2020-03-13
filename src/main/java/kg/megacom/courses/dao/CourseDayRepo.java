package kg.megacom.courses.dao;

import kg.megacom.courses.entities.CourseDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDayRepo extends JpaRepository<CourseDay, Long> {

}
