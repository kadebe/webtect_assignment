package auca.ac.rw.StudentManagement.controller;

import auca.ac.rw.StudentManagement.model.Course;
import auca.ac.rw.StudentManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCourse(@RequestBody Course course) {
        String response = courseService.saveCourse(course);
        if (response.equals("Course with this code already exists")) {
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }
}
