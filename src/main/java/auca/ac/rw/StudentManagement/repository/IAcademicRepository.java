package auca.ac.rw.StudentManagement.repository;

import auca.ac.rw.StudentManagement.model.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IAcademicRepository extends JpaRepository<AcademicUnit, UUID> {
    Optional<AcademicUnit> findByAcademicCode(String academicCode);
}
