package kg.megacom.courses.dao;

import kg.megacom.courses.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepo extends JpaRepository<Classroom, Long> {
}
