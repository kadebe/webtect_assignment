package auca.ac.rw.StudentManagement.service;

import auca.ac.rw.StudentManagement.model.Course;
import auca.ac.rw.StudentManagement.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private ICourseRepository courseRepository;

    public String saveCourse(Course course) {
        Optional<Course> existingCourse = courseRepository.findByCourseCode(course.getCourseCode());

        if (existingCourse.isPresent()) {
            return "Course with this code already exists";
        } else {
            courseRepository.save(course);
            return "Course saved successfully";
        }
    }
}
