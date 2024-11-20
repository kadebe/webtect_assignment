package auca.ac.rw.StudentManagement.repository;

import auca.ac.rw.StudentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IStudentRepository extends JpaRepository<Student, UUID> {

    // Fix the typo here
    Optional<Student> findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, Date dateOfBirth);


    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);


}
