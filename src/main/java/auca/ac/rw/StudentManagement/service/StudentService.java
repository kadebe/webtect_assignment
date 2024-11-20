package auca.ac.rw.StudentManagement.service;


import auca.ac.rw.StudentManagement.model.Student;
import auca.ac.rw.StudentManagement.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private IStudentRepository studentRepository;

    public String saveStudent(Student student) {

        Optional<Student> checkStudent = studentRepository.
                findByFirstNameAndLastNameAndDateOfBirth(
                        student.getFirstName(),
                        student.getLastName(), student.getDateOfBirth());

        if (checkStudent.isPresent()) {
            return "Student Already Exists";
        }
        else {
            studentRepository.save(student);
            return "Student Added";
        }
    }

    public List<Student> getStudentByFirstName(String firstName){
        return studentRepository.findByFirstName(firstName);
    }

    public List<Student> getStudentsByFullName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }


    public Iterable<Student> getAllStudents() {
        {
            return studentRepository.findAll();
    }
}}