package kg.megacom.courses.dao;

import kg.megacom.courses.entities.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepo extends JpaRepository<Day, Long> {
    List<Day> findAllByActiveTrue();
}
