package kg.megacom.courses.dao;

import kg.megacom.courses.entities.Course;
import kg.megacom.courses.entities.Payment;
import kg.megacom.courses.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
    List<Payment> findAllPaymentByStudent(Student student);
    List<Payment> findAllPaymentByCourse(Course course);
}
