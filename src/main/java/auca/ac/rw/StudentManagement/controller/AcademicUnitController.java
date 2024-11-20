package auca.ac.rw.StudentManagement.controller;

import auca.ac.rw.StudentManagement.model.AcademicUnit;

import auca.ac.rw.StudentManagement.service.AcademicUnicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academicUnit")
public class AcademicUnitController {

    @Autowired
    private AcademicUnicService academicUnitService;

    @PostMapping("/save")
    public ResponseEntity<String> saveAcademicUnit(@RequestBody AcademicUnit academicUnit) {
        String response = academicUnitService.saveAcademicUnit(academicUnit);
        if (response.equals("AcademicUnit with this code already exists")) {
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }
}
