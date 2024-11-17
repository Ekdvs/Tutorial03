package com.flower.practical_02.ServiceImplementation;

import com.flower.practical_02.Model.Student;
import com.flower.practical_02.Repository.StudentRepository;
import com.flower.practical_02.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Student existStudent = studentRepository.findById(id).orElseThrow(()-> new RuntimeException());
        existStudent.setFirstName(student.getFirstName());
        existStudent.setLastName(student.getLastName());
        existStudent.setEmail(student.getEmail());
        existStudent.setDepartment(student.getDepartment());
        existStudent.setYearOfEnrollment(student.getYearOfEnrollment());
        return studentRepository.save(existStudent);
    }
}
