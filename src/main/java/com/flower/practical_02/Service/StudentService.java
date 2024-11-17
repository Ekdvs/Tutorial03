package com.flower.practical_02.Service;

import com.flower.practical_02.Model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    void deleteStudentById(Long id);
    Student updateStudent(Student student, Long id);
}
