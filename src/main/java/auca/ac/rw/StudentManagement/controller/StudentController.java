package auca.ac.rw.StudentManagement.controller;

import auca.ac.rw.StudentManagement.model.Student;
import auca.ac.rw.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/saveStudent", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        String saveStudent = studentService.saveStudent(student);
        if (saveStudent.equalsIgnoreCase("student Already exists")) {
            return new ResponseEntity<>(saveStudent, HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
        }
    }

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllStudent() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping(value = "/getstudentbyfirstname", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByFirstName(@RequestParam String firstName) {

        List<Student> students = studentService.getStudentByFirstName(firstName);
        if (students.size() != 0 && !students.isEmpty()) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No students found with the given first name",
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getstudentbyfullName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentByFullName(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        List<Student> students = studentService.getStudentsByFullName(firstName, lastName);
        if (!students.isEmpty()) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No students found with the given full name", HttpStatus.NOT_FOUND);
        }



}

}
