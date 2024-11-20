package auca.ac.rw.StudentManagement.repository;

import auca.ac.rw.StudentManagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ICourseRepository extends JpaRepository<Course, UUID> {
    Optional<Course> findByCourseCode(String courseCode);
}
