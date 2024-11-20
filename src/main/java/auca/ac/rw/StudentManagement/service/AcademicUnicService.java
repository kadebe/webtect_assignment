package auca.ac.rw.StudentManagement.service;

import auca.ac.rw.StudentManagement.model.AcademicUnit;
import auca.ac.rw.StudentManagement.repository.IAcademicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcademicUnicService {

    @Autowired
    private IAcademicRepository academicUnitRepository;

    public String saveAcademicUnit(AcademicUnit academicUnit) {
        Optional<AcademicUnit> existingUnit = academicUnitRepository.findByAcademicCode(academicUnit.getAcademicCode());

        if (existingUnit.isPresent()) {
            return "AcademicUnit with this code already exists";
        } else {
            academicUnitRepository.save(academicUnit);
            return "AcademicUnit saved successfully";
        }
    }
}
